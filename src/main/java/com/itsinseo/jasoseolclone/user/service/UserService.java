package com.itsinseo.jasoseolclone.user.service;

import com.itsinseo.jasoseolclone.common.dto.ApiResponseDto;
import com.itsinseo.jasoseolclone.user.dto.NormalUserSignupRequestDto;
import com.itsinseo.jasoseolclone.user.dto.SigninRequestDto;
import com.itsinseo.jasoseolclone.user.entity.User;
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
     * 회원탈퇴
     * @param userId    회원 탈퇴할 회원 ID
     * @return 탈퇴 요청 처리 결과
     */
    ApiResponseDto withdrawUser(Long userId);

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
