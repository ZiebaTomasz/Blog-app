package com.tomek.controller;

import com.tomek.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts", postService.allPosts());
        return "post/posts";
    }
}
