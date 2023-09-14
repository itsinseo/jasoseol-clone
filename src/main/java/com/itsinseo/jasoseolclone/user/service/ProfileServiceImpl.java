package com.itsinseo.jasoseolclone.user.service;

import com.itsinseo.jasoseolclone.common.ApiResponseDto;
import com.itsinseo.jasoseolclone.user.dto.ProfileCreateRequestDto;
import com.itsinseo.jasoseolclone.user.dto.ProfileResponseDto;
import com.itsinseo.jasoseolclone.user.dto.ProfileUpdateRequestDto;
import com.itsinseo.jasoseolclone.user.entity.Profile;
import com.itsinseo.jasoseolclone.user.entity.User;
import com.itsinseo.jasoseolclone.user.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final UserService userService;

    @Override
    public ApiResponseDto createProfile(ProfileCreateRequestDto profileCreateRequestDto, Long user_id) {
        String name = profileCreateRequestDto.getName();
        String introduction = profileCreateRequestDto.getIntroduction();

        Profile profile = Profile.builder()
                .name(name)
                .introduction(introduction)
                .build();

        User user = userService.findUserById(user_id);
        profile.setUser(user);
        user.setProfile(profile);

        profileRepository.save(profile);

        return new ApiResponseDto("프로필 생성이 완료되었습니다.");
    }

    @Override
    public ProfileResponseDto getProfile(User user) {
        Profile profile = user.getProfile();

        return new ProfileResponseDto(profile);
    }

    @Override
    @Transactional
    public ApiResponseDto updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto, User user) {
        String introduction = profileUpdateRequestDto.getIntroduction();

        Profile profile = user.getProfile();
        profile.setIntroduction(introduction);
        profileRepository.save(profile);

        return new ApiResponseDto("프로필 수정이 완료되었습니다.");
    }

    @Override
    public Profile findProfileById(Long profileId) {
        return profileRepository.findById(profileId).orElseThrow(() ->
                new IllegalArgumentException("프로필이 존재하지 않습니다."));
    }
}
