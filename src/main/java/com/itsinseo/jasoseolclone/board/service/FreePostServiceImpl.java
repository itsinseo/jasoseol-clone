package com.itsinseo.jasoseolclone.board.service;

import com.itsinseo.jasoseolclone.awsS3.FileUploadService;
import com.itsinseo.jasoseolclone.awsS3.FileUtil;
import com.itsinseo.jasoseolclone.board.dto.FreePostDetailResponseDto;
import com.itsinseo.jasoseolclone.board.dto.FreePostRequestDto;
import com.itsinseo.jasoseolclone.board.dto.FreePostSimpleResponseDto;
import com.itsinseo.jasoseolclone.board.entity.FreePost;
import com.itsinseo.jasoseolclone.board.repository.FreePostRepository;
import com.itsinseo.jasoseolclone.common.ApiResponseDto;
import com.itsinseo.jasoseolclone.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FreePostServiceImpl implements FreePostService {

    private final FreePostRepository freePostRepository;
    private final FileUploadService fileUploadService;
    private final FileUtil fileUtil;

    @Override
    public ApiResponseDto createFreePost(FreePostRequestDto freePostRequestDto, MultipartFile file, User user) {
        String fileName = null;
        if (!file.isEmpty()) {
            String fileUrl = fileUploadService.uploadFile(file);
            fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        }

        FreePost freePost = FreePost.builder()
                .title(freePostRequestDto.getTitle())
                .content(freePostRequestDto.getContent())
                .fileName(fileName)
                .user(user)
                .build();

        freePostRepository.save(freePost);

        return new ApiResponseDto("자유게시판 글 작성 완료");
    }

    @Override
    public List<FreePostSimpleResponseDto> getAllFreePosts() {
        return null;
    }

    @Override
    public List<FreePostSimpleResponseDto> getFreePostsPaging(Pageable pageable) {
        return null;
    }

    @Override
    public FreePostDetailResponseDto getFreePost(Long freePostId) {
        FreePost freePost = findFreePostById(freePostId);
        String imageUrl = fileUtil.convertFileNameToOriginalUrl(freePost.getFileName());

        return new FreePostDetailResponseDto(freePost, imageUrl);
    }

    @Override
    public ApiResponseDto updateFreePost(Long freePostId, FreePostRequestDto freePostRequestDto, MultipartFile file) {
        return null;
    }

    @Override
    public ApiResponseDto deleteFreePost(Long freePostId) {
        return null;
    }

    @Override
    public FreePost findFreePostById(Long freePostId) {
        return freePostRepository.findById(freePostId).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
    }
}
