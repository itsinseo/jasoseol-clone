package com.itsinseo.jasoseolclone.user.entity;

import com.itsinseo.jasoseolclone.board.entity.Board;
import com.itsinseo.jasoseolclone.resume.entity.Resume;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
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
    private String accountType;

    // 소셜 계정 여부 및 종류 - jasoseol, kakao, naver, google, etc.
    @Column(nullable = false)
    private String signupType;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Board> boardList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Resume> resumeList;
}
