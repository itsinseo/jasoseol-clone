package com.itsinseo.jasoseolclone.user.controller;

import com.itsinseo.jasoseolclone.common.dto.ApiResponseDto;
import com.itsinseo.jasoseolclone.security.UserDetailsImpl;
import com.itsinseo.jasoseolclone.user.dto.ProfileCreateRequestDto;
import com.itsinseo.jasoseolclone.user.dto.ProfileResponseDto;
import com.itsinseo.jasoseolclone.user.dto.ProfileUpdateRequestDto;
import com.itsinseo.jasoseolclone.user.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jss/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ApiResponseDto createProfile(@RequestBody ProfileCreateRequestDto profileCreateRequestDto,
                                        @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return profileService.createProfile(profileCreateRequestDto, userDetails.getUser().getUserId());
    }

    @GetMapping
    public ProfileResponseDto getProfile(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return profileService.getProfile(userDetails.getUser());
    }

    @PutMapping
    public ApiResponseDto updateProfile(@RequestBody ProfileUpdateRequestDto profileUpdateRequestDto,
                                        @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return profileService.updateProfile(profileUpdateRequestDto, userDetails.getUser());
    }
}
