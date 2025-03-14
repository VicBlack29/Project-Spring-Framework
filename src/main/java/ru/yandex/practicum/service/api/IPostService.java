package ru.yandex.practicum.service.api;

import ru.yandex.practicum.model.entity.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {

    List<Post> getAll();

    Post getById(Long id);

}
