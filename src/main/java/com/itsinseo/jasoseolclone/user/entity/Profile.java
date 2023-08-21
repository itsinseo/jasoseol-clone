package com.itsinseo.jasoseolclone.user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(nullable = false)
    private String name;

    // 자기소개 - 큰 데이터 타입일 예정
    @Column(nullable = false)
    private String introduction;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
