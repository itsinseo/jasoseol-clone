package com.itsinseo.jasoseolclone.user;

public class UserRegularExpression {
    public static final String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z]+)(?=.*[0-9]+)(?=.*[`~!@#\\$%\\^&\\*\\(\\)_=+\\[\\{\\]};:'\",<.>/?]+).{8,20}$";
}
