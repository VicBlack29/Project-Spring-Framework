package ru.yandex.practicum.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.model.dao.api.IEntityDao;
import ru.yandex.practicum.model.entity.Post;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Component
public class PostDao implements IEntityDao<Post> {

    private Connection connection;

//    @Autowired
//    public PostDao(Connection connection) {
//        this.connection = connection;
//    }

    @Override
    public List<Post> getAll() {
        return List.of();
    }

    @Override
    public Optional<Post> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public void delete(Post post) {

    }

}
