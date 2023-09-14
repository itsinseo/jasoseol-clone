package com.itsinseo.jasoseolclone.comment.entity;

import com.itsinseo.jasoseolclone.board.entity.FreePost;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "free_post_id")
    private FreePost freePost;
}
