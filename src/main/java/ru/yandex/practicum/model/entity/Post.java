package ru.yandex.practicum.model.entity;

import java.util.List;

public class Post {
    private Long id;
    private String title;
    private String text;
    private String imagePath;
    private Integer likesCount;
    private List<Comment> comments;
    private String tags;

    public Post() {

    }

    public Post(Long id, String title, String text, String imagePath, Integer likesCount, List<Comment> comments, String tags) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.imagePath = imagePath;
        this.likesCount = likesCount;
        this.comments = comments;
        this.tags = tags;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
