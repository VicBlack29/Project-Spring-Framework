package ru.yandex.practicum.service.api;

import ru.yandex.practicum.model.entity.Post;

import java.util.List;

public interface IPostService {

    List<Post> getAll();

}
