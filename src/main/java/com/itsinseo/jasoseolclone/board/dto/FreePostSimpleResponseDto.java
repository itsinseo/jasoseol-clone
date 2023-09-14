package com.itsinseo.jasoseolclone.board.dto;

import com.itsinseo.jasoseolclone.board.entity.FreePost;
import com.itsinseo.jasoseolclone.common.TimeFormatter;
import lombok.Getter;

@Getter
public class FreePostSimpleResponseDto {

    private final String title;
    private final String modifiedAt;

    public FreePostSimpleResponseDto(FreePost freePost) {
        this.title = freePost.getTitle();
        this.modifiedAt = TimeFormatter.simpleTime(freePost.getModifiedAt());
    }
}
