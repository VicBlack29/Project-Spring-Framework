package ru.yandex.practicum.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long id;
    private String title;
    private String text;
    private String imagePath;
    private int likesCount;
    private List<Comment> comments;
    private String tags;

}
