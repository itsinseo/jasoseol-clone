package com.itsinseo.jasoseolclone.enterprise.entity;

import com.itsinseo.jasoseolclone.resume.entity.Resume;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enterpriseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
    private List<Resume> resumeList;
}
