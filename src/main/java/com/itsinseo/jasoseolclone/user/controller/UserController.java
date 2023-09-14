package com.itsinseo.jasoseolclone.user.controller;

import com.itsinseo.jasoseolclone.common.ApiResponseDto;
import com.itsinseo.jasoseolclone.security.UserDetailsImpl;
import com.itsinseo.jasoseolclone.user.dto.NormalUserSignupRequestDto;
import com.itsinseo.jasoseolclone.user.dto.PasswordChangeRequestDto;
import com.itsinseo.jasoseolclone.user.dto.SigninRequestDto;
import com.itsinseo.jasoseolclone.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jss/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponseDto signupNormalUser(@Valid @RequestBody NormalUserSignupRequestDto requestDto,
                                           BindingResult bindingResult) {
        return userService.signupNormalUser(requestDto);
    }

    @PostMapping("/signin")
    public ApiResponseDto signin(@RequestBody SigninRequestDto signinRequestDto, HttpServletResponse httpServletResponse) {
        return userService.signin(signinRequestDto, httpServletResponse);
    }


    @PostMapping("/signout")
    public ApiResponseDto signout(HttpServletRequest request) {
        return userService.signout(request);
    }

    @DeleteMapping("/withdraw")
    public ApiResponseDto withdraw(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.withdraw(userDetails.getUser().getUserId());
    }

    @PutMapping("/password")
    public ApiResponseDto changePassword(@Valid @RequestBody PasswordChangeRequestDto passwordChangeRequestDto,
                                         BindingResult bindingResult,
                                         @AuthenticationPrincipal UserDetailsImpl userDetails,
                                         HttpServletRequest httpServletRequest) {
        return userService.changePassword(userDetails.getUser(), passwordChangeRequestDto, httpServletRequest);
    }
}
