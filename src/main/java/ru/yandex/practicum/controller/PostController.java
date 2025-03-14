package ru.yandex.practicum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.model.dao.api.IEntityDao;
import ru.yandex.practicum.model.entity.Paging;
import ru.yandex.practicum.model.entity.Post;
import ru.yandex.practicum.service.api.IPostService;
import ru.yandex.practicum.service.impl.PostService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping()
public class PostController {

    private IPostService postService;

    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String get() {
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        model.addAttribute("search", "");
        Paging paging = new Paging();
        model.addAttribute("paging", paging);

        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable(name = "id") Long id, Model model) {
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/posts/add")
    public String getAddPostPage() {
        return "add-post";
    }

    @PostMapping("/posts")
    public String addPost(){
        return "redirect:/posts/{id}";
    }

}
