package com.itsinseo.jasoseolclone.recruitment.entity;

import com.itsinseo.jasoseolclone.enterprise.entity.Enterprise;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "recruitments")
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitmentId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
}
