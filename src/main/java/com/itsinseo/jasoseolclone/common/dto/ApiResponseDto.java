package com.itsinseo.jasoseolclone.common.dto;

import lombok.Getter;

@Getter
public class ApiResponseDto {
    private Integer statusCode;
    private String message;

    public ApiResponseDto(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}