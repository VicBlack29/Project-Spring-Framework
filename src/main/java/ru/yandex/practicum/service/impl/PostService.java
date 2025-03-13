package ru.yandex.practicum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.model.dao.api.IEntityDao;
import ru.yandex.practicum.model.entity.Comment;
import ru.yandex.practicum.model.entity.Post;
import ru.yandex.practicum.repository.api.IPostRepository;
import ru.yandex.practicum.service.api.IPostService;

@Service
public class PostService implements IPostService {

    private IEntityDao<Post> postDao;
    private IEntityDao<Comment> commentDao;
    private IPostRepository postRepository;

    @Autowired
    public PostService(IEntityDao<Post> postDao, IEntityDao<Comment> commentDao, IPostRepository postRepository) {
        this.postDao = postDao;
        this.commentDao = commentDao;
        this.postRepository = postRepository;
    }

}
