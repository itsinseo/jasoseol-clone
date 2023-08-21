package com.itsinseo.jasoseolclone.board.entity;

import com.itsinseo.jasoseolclone.comment.entity.Comment;
import com.itsinseo.jasoseolclone.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comment> commentList;
}
