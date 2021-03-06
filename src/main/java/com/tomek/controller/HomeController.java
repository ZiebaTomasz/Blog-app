package com.tomek.controller;

import com.tomek.service.PostService;
import com.tomek.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    PostService postService;
    WriterService writerService;

    @Autowired
    public HomeController(PostService postService, WriterService writerService) {
        this.postService = postService;
        this.writerService = writerService;
    }

    @RequestMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/international")
    public String getInternationalPage() {
        return "post/posts";
    }


}
