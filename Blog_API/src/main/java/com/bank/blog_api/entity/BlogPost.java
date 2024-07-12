package com.bank.blog_api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false,columnDefinition = "Text")
    private String content;
    @Column(nullable = false)
    private LocalDateTime createdat;
    @Column(nullable = false)
    private LocalDateTime updatedat;

    public BlogPost(String title, String content, LocalDateTime createdat, LocalDateTime updatedat) {

        this.title = title;
        this.content = content;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public BlogPost() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }
}
