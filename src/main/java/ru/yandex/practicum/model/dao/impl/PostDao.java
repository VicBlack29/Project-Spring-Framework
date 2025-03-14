package ru.yandex.practicum.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.model.dao.api.IEntityDao;
import ru.yandex.practicum.model.entity.Comment;
import ru.yandex.practicum.model.entity.Post;

import java.util.List;
import java.util.Optional;

@Component
public class PostDao implements IEntityDao<Post> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> getAll() {
        return jdbcTemplate.query(
                "select id, title, text, image_path, likes_count, comments_id, tags from public.posts;",
                (rs, rowNum) -> new Post(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("text"),
                        rs.getString("image_path"),
                        rs.getInt("likes_count"),
                        jdbcTemplate.query(
                            String.format(
                                    "select id, post_id, text from comments where post_id = %d;",
                                    rs.getLong("id")
                            ),
                            new BeanPropertyRowMapper<>(Comment.class)
                        ),
                        rs.getString("tags")
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
