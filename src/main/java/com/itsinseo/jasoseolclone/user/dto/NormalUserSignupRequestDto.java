package com.itsinseo.jasoseolclone.user.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import static com.itsinseo.jasoseolclone.user.UserRegularExpression.EMAIL_REGEX;
import static com.itsinseo.jasoseolclone.user.UserRegularExpression.PASSWORD_REGEX;

@Getter
public class NormalUserSignupRequestDto {

    @Pattern(regexp = EMAIL_REGEX, message = "아이디는 이메일 형식이어야 합니다. ")
    private String username;

    @Pattern(regexp = PASSWORD_REGEX, message = "비밀번호는 알파벳, 숫자, 특수문자를 최소 1개씩 포함하여 8자 이상 20자 미만이어야 합니다. ")
    private String password;
}
