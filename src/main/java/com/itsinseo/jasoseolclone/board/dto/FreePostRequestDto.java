package com.itsinseo.jasoseolclone.board.dto;

import lombok.Getter;

@Getter
public class FreePostRequestDto {

    private String title;
    private String content;

    public FreePostRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
