package com.itsinseo.jasoseolclone.user.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import static com.itsinseo.jasoseolclone.user.UserRegularExpression.*;

@Getter
public class NormalUserSignupRequestDto {

    @Pattern(regexp = EMAIL_REGEX, message = EMAIL_DEFAULT_MESSAGE)
    private String username;

    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_DEFAULT_MESSAGE)
    private String password;
}
