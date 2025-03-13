package ru.yandex.practicum.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.model.dao.api.IEntityDao;
import ru.yandex.practicum.model.entity.Comment;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Component
public class CommentDao implements IEntityDao<Comment> {

    private Connection connection;

//    @Autowired
//    public CommentDao(Connection connection) {
//        this.connection = connection;
//    }

    @Override
    public List<Comment> getAll() {
        return List.of();
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Comment comment) {

    }

    @Override
    public void delete(Comment comment) {

    }
}
