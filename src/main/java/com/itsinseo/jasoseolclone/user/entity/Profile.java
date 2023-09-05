package com.itsinseo.jasoseolclone.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Builder
    public Profile(Long profileId, String name, String introduction) {
        this.profileId = profileId;
        this.name = name;
        this.introduction = introduction;
    }
}
