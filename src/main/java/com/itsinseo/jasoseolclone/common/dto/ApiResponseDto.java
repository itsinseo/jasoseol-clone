package com.itsinseo.jasoseolclone.common.dto;

import lombok.Getter;

@Getter
public class ApiResponseDto {
    private Long statusCode;
    private String messageCode;

    public ApiResponseDto(Long statusCode, String messageCode) {
        this.statusCode = statusCode;
        this.messageCode = messageCode;
    }
}