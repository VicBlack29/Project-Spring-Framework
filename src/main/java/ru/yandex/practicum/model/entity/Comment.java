package ru.yandex.practicum.model.entity;

public class Comment {

    private Long id;
    private String text;

    public Comment(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
