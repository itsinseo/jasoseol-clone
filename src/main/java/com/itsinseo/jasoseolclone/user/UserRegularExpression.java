package com.itsinseo.jasoseolclone.user;

public class UserRegularExpression {
    public static final String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z]+)(?=.*[0-9]+)(?=.*[`~!@#\\$%\\^&\\*\\(\\)_=+\\[\\{\\]};:'\",<.>/?]+).{8,20}$";

    public static final String EMAIL_DEFAULT_MESSAGE = "아이디는 이메일 형식이어야 합니다. ";
    public static final String PASSWORD_DEFAULT_MESSAGE = "비밀번호는 알파벳, 숫자, 특수문자를 최소 1개씩 포함하여 8자 이상 20자 미만이어야 합니다. ";
}
