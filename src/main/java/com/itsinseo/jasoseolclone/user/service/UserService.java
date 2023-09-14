package com.itsinseo.jasoseolclone.user.service;

import com.itsinseo.jasoseolclone.common.ApiResponseDto;
import com.itsinseo.jasoseolclone.user.dto.NormalUserSignupRequestDto;
import com.itsinseo.jasoseolclone.user.dto.PasswordChangeRequestDto;
import com.itsinseo.jasoseolclone.user.dto.SigninRequestDto;
import com.itsinseo.jasoseolclone.user.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {

    /**
     * 회원가입
     * @param requestDto 회원가입 요청 데이터
     * @return 요청 처리 결과
     */
    ApiResponseDto signupNormalUser(NormalUserSignupRequestDto requestDto);

    /**
     * 로그인
     *
     * @param signinRequestDto    로그인 요청 데이터
     * @param httpServletResponse   헤더에 토큰을 추가할 response
     * @return 로그인 요청 처리 결과
     */
    ApiResponseDto signin(SigninRequestDto signinRequestDto, HttpServletResponse httpServletResponse);

    /**
     * 로그아웃
     * @param request   로그아웃 요청 (헤더에서 토큰값을 가져오기 위함)
     * @return 로그아웃 요청 처리 결과
     */
    ApiResponseDto signout(HttpServletRequest request);

    /**
     * 회원탈퇴
     * @param userId    회원 탈퇴할 회원 ID
     * @return 탈퇴 요청 처리 결과
     */
    ApiResponseDto withdraw(Long userId);

    /**
     * 회원 비밀번호 변경
     * @param user  비밀번호를 변경할 회원
     * @param passwordRequestDto    비밀번호 변경 요청 데이터
     * @param httpServletRequest    요청 헤더 (헤더에서 토큰값을 가져오기 위함)
     * @return 비밀번호 변경 요청 처리 결과
     */
    ApiResponseDto changePassword(User user, PasswordChangeRequestDto passwordRequestDto, HttpServletRequest httpServletRequest);

    /**
     * ID(고유값)으로 회원 찾기
     * @param userId    찾을 회원 ID
     * @return 찾은 회원
     */
    User findUserById(Long userId);

    /**
     * 아이디로 회원 찾기
     * @param username 찾을 회원 아이디
     * @return 찾은 회원
     */
    User findUserByUsername(String username);
}
