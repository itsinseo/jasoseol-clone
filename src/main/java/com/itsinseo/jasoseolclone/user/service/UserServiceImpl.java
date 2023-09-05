package com.itsinseo.jasoseolclone.user.service;

import com.itsinseo.jasoseolclone.common.dto.ApiResponseDto;
import com.itsinseo.jasoseolclone.jwt.JwtUtil;
import com.itsinseo.jasoseolclone.user.RandomAnimalNickname;
import com.itsinseo.jasoseolclone.user.dto.NormalUserSignupRequestDto;
import com.itsinseo.jasoseolclone.user.dto.SigninRequestDto;
import com.itsinseo.jasoseolclone.user.entity.User;
import com.itsinseo.jasoseolclone.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.itsinseo.jasoseolclone.user.UserAccountType.NORMAL_USER;
import static com.itsinseo.jasoseolclone.user.UserSignupType.JASOSEOL;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RandomAnimalNickname randomAnimalNickname;
    private final JwtUtil jwtUtil;

    @Override
    public ApiResponseDto signupNormalUser(NormalUserSignupRequestDto requestDto) {
        String username = requestDto.getUsername();

        if (userRepository.existsUserByUsername(username)) {
            throw new DataIntegrityViolationException("이미 존재하는 아이디입니다.");
        }

        String rawPassword = requestDto.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        User user = User.builder()
                .username(username)
                .password(encodedPassword)
                .nickname(randomAnimalNickname.generateRandomNickname())
                .accountType(NORMAL_USER)
                .signupType(JASOSEOL)
                .build();

        userRepository.save(user);

        return new ApiResponseDto("회원가입이 완료되었습니다!");
    }

    @Override
    public ApiResponseDto signin(SigninRequestDto signinRequestDto, HttpServletResponse httpServletResponse) {
        String username = signinRequestDto.getUsername();
        User user = findUserByUsername(username);

        String rawPassword = signinRequestDto.getPassword();
        if(!passwordEncoder.matches(rawPassword, user.getPassword())){
            throw new IllegalArgumentException("비밀번호 오류입니다.");
        }

        // Access Token 을 헤더에 추가
        String accessToken = jwtUtil.createAccessToken(user.getUsername());
        httpServletResponse.addHeader(JwtUtil.AUTHORIZATION_HEADER, accessToken);

        return new ApiResponseDto("로그인 성공!");
    }

    @Override
    @Transactional
    public ApiResponseDto withdrawUser(Long userId) {
        User user = findUserById(userId);
        userRepository.delete(user);

        return new ApiResponseDto("회원탈퇴가 완료되었습니다.");
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new IllegalArgumentException("해당 아이디의 회원이 존재하지 않습니다."));
    }
}
