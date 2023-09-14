package com.itsinseo.jasoseolclone.user.service;

import com.itsinseo.jasoseolclone.common.ApiResponseDto;
import com.itsinseo.jasoseolclone.user.dto.ProfileCreateRequestDto;
import com.itsinseo.jasoseolclone.user.dto.ProfileResponseDto;
import com.itsinseo.jasoseolclone.user.dto.ProfileUpdateRequestDto;
import com.itsinseo.jasoseolclone.user.entity.Profile;
import com.itsinseo.jasoseolclone.user.entity.User;

public interface ProfileService {

    /**
     * 프로필 생성 (최초 1회)
     * @param profileCreateRequestDto   프로필 생성 요청 데이터
     * @param user_id   프로필을 연결할 회원 ID
     * @return 프로필 생성 요청 처리 결과
     */
    ApiResponseDto createProfile(ProfileCreateRequestDto profileCreateRequestDto, Long user_id);

    /**
     * 프로필 조회
     * @param user    프로필을 조회할 회원
     * @return 조회한 프로필 데이터
     */
    ProfileResponseDto getProfile(User user);

    /**
     * 프로필 수정
     * @param profileUpdateRequestDto 프로필 수정 요청 데이터
     * @param user    프로필을 수정할 회원
     * @return 프로필 수정 요청 처리 결과
     */
    ApiResponseDto updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto, User user);

    /**
     * 프로필 찾기
     * @param profileId 찾을 프로필 ID
     * @return 찾은 프로필
     */
    Profile findProfileById(Long profileId);
}
