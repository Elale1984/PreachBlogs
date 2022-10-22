package com.gcu.preach.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data

@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {


    private int id;
    @NotNull(message="Title field cannot be empty!")
    @Size(min=1, max=60, message="Title field must be between 1 and 60 characters long!")
    private String title;
    @NotNull(message="Content Preview field cannot be empty!")
    @Size(min=60, max=10000, message="Content Preview field must be between 60 and 150 characters long!")
    private String contentPreview;
    @NotNull(message="Blog Content field cannot be empty!")
    @Size(min=100, max=10000000, message="Blog Content field must be between 1 and 600000 characters long!")
    private String fullContent;
    @NotNull(message="Author field cannot be empty!")
    @Size(min=1, max=30, message="Author field must be between 1 and 30 characters long!")
    private String author;
    @NotNull(message="Date field cannot be empty!")
    @Size(min=8, max=10, message="Date field must be between 4 and 20 characters long!")
    private String date;

    private int likes;



    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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

    public String getContentPreview() {
        return contentPreview;
    }

    public void setContentPreview(String contentPreview) {
        this.contentPreview = contentPreview;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
