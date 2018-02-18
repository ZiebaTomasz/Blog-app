package com.tomek.controller;

import com.tomek.domain.Post;
import com.tomek.domain.observer.PostObserver;
import com.tomek.domain.observer.SingleNotifier;
import com.tomek.service.PostService;
import com.tomek.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

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
        return "login_register/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "observer/registerObserver";
    }


}
