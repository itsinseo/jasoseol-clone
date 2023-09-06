package com.itsinseo.jasoseolclone.user.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import static com.itsinseo.jasoseolclone.user.UserRegularExpression.PASSWORD_DEFAULT_MESSAGE;
import static com.itsinseo.jasoseolclone.user.UserRegularExpression.PASSWORD_REGEX;

@Getter
public class PasswordChangeRequestDto {

    private String oldPassword;

    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_DEFAULT_MESSAGE)
    private String newPassword;
    private String newPasswordConfirm;
}
