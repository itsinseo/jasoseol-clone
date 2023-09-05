package com.itsinseo.jasoseolclone.user.dto;

import com.itsinseo.jasoseolclone.user.entity.Profile;
import lombok.Getter;

@Getter
public class ProfileResponseDto {

    private final String name;
    private final String introduction;

    public ProfileResponseDto(Profile profile) {
        this.name = profile.getName();
        this.introduction = profile.getIntroduction();
    }
}
