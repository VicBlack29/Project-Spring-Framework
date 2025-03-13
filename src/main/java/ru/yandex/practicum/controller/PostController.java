package ru.yandex.practicum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class PostController {

    @GetMapping("/")
    public String get() {
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String getPosts() {
        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String getPostById() {
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
