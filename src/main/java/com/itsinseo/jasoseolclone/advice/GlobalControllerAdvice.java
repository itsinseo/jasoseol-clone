package com.itsinseo.jasoseolclone.advice;

import com.itsinseo.jasoseolclone.common.ApiResponseDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler({IllegalArgumentException.class, DataIntegrityViolationException.class,
            RejectedExecutionException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseDto handleException(Exception e) {
        return new ApiResponseDto(e.getMessage());
    }

    @ExceptionHandler({IOException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseDto handleIOException(Exception e) {
        return new ApiResponseDto(e.getMessage());
    }
}