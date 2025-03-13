package ru.yandex.practicum.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.model.dao.api.IEntityDao;
import ru.yandex.practicum.model.entity.Comment;
import ru.yandex.practicum.model.entity.Post;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Component
public class PostDao implements IEntityDao<Post> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> getAll() {
        return jdbcTemplate.query(
                "select id, title, text, imagePath, likes_count, comments_id from posts",
                (rs, rowNum) -> new Post(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("text"),
                        rs.getString("imagePath"),
                        rs.getInt("likesCount"),
                        jdbcTemplate.queryForList("select id, text from comments", Comment.class)
                ));
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
