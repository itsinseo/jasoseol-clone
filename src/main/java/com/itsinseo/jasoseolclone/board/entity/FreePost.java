package com.itsinseo.jasoseolclone.board.entity;

import com.itsinseo.jasoseolclone.comment.entity.Comment;
import com.itsinseo.jasoseolclone.common.Timestamp;
import com.itsinseo.jasoseolclone.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "free_posts")
public class FreePost extends Timestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "freePost", fetch = FetchType.LAZY)
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public FreePost(String title, String content, String fileName, User user) {
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.user = user;
    }
}
