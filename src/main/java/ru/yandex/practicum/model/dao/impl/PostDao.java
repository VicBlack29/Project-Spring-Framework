package ru.yandex.practicum.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.model.dao.api.IEntityDao;
import ru.yandex.practicum.model.entity.Comment;
import ru.yandex.practicum.model.entity.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class PostDao implements IEntityDao<Post> {

    private final Connection connection;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDao(Connection connection, JdbcTemplate jdbcTemplate) {
        this.connection = connection;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> getAll() {
        return jdbcTemplate.query(
                "select id, title, text, image_path, likes_count, tags from public.posts;",
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
        return Optional.ofNullable(
                jdbcTemplate.queryForObject(
                        String.format(
                                "select * from public.posts where id = %d;",
                                id
                        ),
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
                        )
                )
        );
    }

    @Override
    public void save(Post post) {
        try (PreparedStatement ps = connection.prepareStatement(
        """
                insert into public.posts
                (title, text, image_path, likes_count, tags)
                values
                (?, ?, ?, ?, ?);
                """
        )) {
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getText());
            ps.setString(3, post.getImagePath());
            ps.setInt(4, post.getLikesCount());
            ps.setString(5, post.getTags());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Post post) {

    }

}
