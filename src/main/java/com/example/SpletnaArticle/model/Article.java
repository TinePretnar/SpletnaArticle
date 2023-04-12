package com.example.SpletnaArticle.model;

import java.time.LocalDate;

public class Article {

    private int id;
    private String title;
    private String content;
    private LocalDate publishedDate;

    private LocalDate createdDate;
    private String author;
    private String subtitle;

    public Article(int id, String title, String subtitle, String content, LocalDate publishedDate, LocalDate createdDate, String author) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.publishedDate = publishedDate;
        this.createdDate = createdDate;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate date) {
        this.publishedDate = date;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate date) {
        this.createdDate = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
