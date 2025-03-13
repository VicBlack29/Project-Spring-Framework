package ru.yandex.practicum.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.model.dao.api.IEntityDao;
import ru.yandex.practicum.model.entity.Comment;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Component
public class CommentDao implements IEntityDao<Comment> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comment> getAll() {
        return jdbcTemplate.query(
                "select id, text from public.comments;",
                (rs, rowNum) -> new Comment(
                        rs.getLong("id"),
                        rs.getString("text")
                )
        );
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
