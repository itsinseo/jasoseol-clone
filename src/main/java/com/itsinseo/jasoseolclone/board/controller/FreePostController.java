package com.itsinseo.jasoseolclone.board.controller;

import com.itsinseo.jasoseolclone.board.dto.FreePostDetailResponseDto;
import com.itsinseo.jasoseolclone.board.dto.FreePostRequestDto;
import com.itsinseo.jasoseolclone.board.dto.FreePostSimpleResponseDto;
import com.itsinseo.jasoseolclone.board.service.FreePostService;
import com.itsinseo.jasoseolclone.common.ApiResponseDto;
import com.itsinseo.jasoseolclone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/jss/board/free")
@RequiredArgsConstructor
public class FreePostController {

    private final FreePostService freePostService;

    @PostMapping
    public ApiResponseDto createFreePost(@ModelAttribute FreePostRequestDto freePostRequestDto,
                                         @RequestParam("file") MultipartFile file,
                                         @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return freePostService.createFreePost(freePostRequestDto, file, userDetails.getUser());
    }

    @GetMapping("/all")
    public List<FreePostSimpleResponseDto> getAllFreePosts() {
        return freePostService.getAllFreePosts();
    }

    @GetMapping
    public List<FreePostSimpleResponseDto> getFreePostsPaging(Pageable pageable) {
        return freePostService.getFreePostsPaging(pageable);
    }

    @GetMapping("/{freePostId}")
    public FreePostDetailResponseDto getFreePost(@PathVariable Long freePostId) {
        return freePostService.getFreePost(freePostId);
    }

    @PutMapping("/{freePostId}")
    public ApiResponseDto updateFreePost(@PathVariable Long freePostId,
                                         @ModelAttribute FreePostRequestDto freePostRequestDto,
                                         @RequestParam("file") MultipartFile file,
                                         @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return freePostService.updateFreePost(freePostId, freePostRequestDto, file);
    }

    @DeleteMapping("/{freePostId}")
    public ApiResponseDto deleteFreePost(@PathVariable Long freePostId,
                                         @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return freePostService.deleteFreePost(freePostId);
    }
}
