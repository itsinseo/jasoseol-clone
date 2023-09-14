package com.itsinseo.jasoseolclone.board.dto;

import com.itsinseo.jasoseolclone.board.entity.FreePost;
import com.itsinseo.jasoseolclone.common.TimeFormatter;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FreePostDetailResponseDto {

    private final String title;
    private final String content;
    private final String imageUrl;
    private final String modifiedAt;

    @Builder
    public FreePostDetailResponseDto(FreePost freePost, String imageUrl) {
        this.title = freePost.getTitle();
        this.content = freePost.getContent();
        this.imageUrl = imageUrl;
        this.modifiedAt = TimeFormatter.simpleTime(freePost.getModifiedAt());
    }
}
