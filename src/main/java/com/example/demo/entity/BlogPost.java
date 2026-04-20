package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "blogPosts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Long getId() {
        return id;
    }

    private String title;

    @Column(columnDefinition = "TEXT")
    private String post;


    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }
    public BlogPost(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public BlogPost(Long id, Author author, String title, String post) {
        this.id = id;
        this.author = author;
        this.title=title;
        this.post=post;
    }
}
