package com.itsinseo.jasoseolclone.board.service;

import com.itsinseo.jasoseolclone.board.dto.FreePostDetailResponseDto;
import com.itsinseo.jasoseolclone.board.dto.FreePostRequestDto;
import com.itsinseo.jasoseolclone.board.dto.FreePostSimpleResponseDto;
import com.itsinseo.jasoseolclone.board.entity.FreePost;
import com.itsinseo.jasoseolclone.common.ApiResponseDto;
import com.itsinseo.jasoseolclone.user.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

public interface FreePostService {
    /**
     * 자유게시판 글 작성
     * @param freePostRequestDto    글 제목, 내용
     * @param file  첨부 파일
     * @param user  작성자
     * @return 요청 처리 결과
     */
    ApiResponseDto createFreePost(FreePostRequestDto freePostRequestDto, MultipartFile file, User user);

    /**
     * 자유게시판 글 전체 조회
     * @return 조회 결과
     */
    List<FreePostSimpleResponseDto> getAllFreePosts();

    /**
     * 자유게시판 글 페이징 조회
     * @param pageable  페이징 조건
     * @return 조회 결과
     */
    List<FreePostSimpleResponseDto> getFreePostsPaging(Pageable pageable);

    /**
     * 자유게시판 글 단건 조회
     * @param freePostId    조회할 글 ID
     * @return 조회 결과
     */
    FreePostDetailResponseDto getFreePost(Long freePostId);

    /**
     * 자유게시판 글 수정
     * @param freePostId    수정할 글 ID
     * @param freePostRequestDto    수정 제목, 내용
     * @param file  수정할 파일
     * @return 요청 처리 결과
     */
    ApiResponseDto updateFreePost(Long freePostId, FreePostRequestDto freePostRequestDto, MultipartFile file);

    /**
     * 자유게시판 글 삭제
     * @param freePostId    삭제할 글 ID
     * @return 요청 처리 결과
     */
    ApiResponseDto deleteFreePost(Long freePostId);

    /**
     * 자유게시판 글 조회
     * @param freePostId   조회할 글 ID
     * @return 조회한 글 (Entity)
     */
    FreePost findFreePostById(Long freePostId);
}
