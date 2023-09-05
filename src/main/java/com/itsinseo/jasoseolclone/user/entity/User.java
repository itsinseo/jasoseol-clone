package com.itsinseo.jasoseolclone.user.entity;

import com.itsinseo.jasoseolclone.board.entity.Board;
import com.itsinseo.jasoseolclone.resume.entity.Resume;
import com.itsinseo.jasoseolclone.user.UserAccountType;
import com.itsinseo.jasoseolclone.user.UserSignupType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    // Admin, NormalUser, EnterpriseUser
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserAccountType accountType;

    // 소셜 계정 여부 및 종류 - jasoseol, kakao, naver, google, etc.
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserSignupType signupType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Resume> resumeList = new ArrayList<>();

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Builder
    public User(String username, String password, String nickname, UserAccountType accountType, UserSignupType signupType,
                Profile profile) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.accountType = accountType;
        this.signupType = signupType;
    }
}
