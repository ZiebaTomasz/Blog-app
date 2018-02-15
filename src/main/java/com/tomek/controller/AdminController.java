package com.tomek.controller;

import com.tomek.service.PostService;
import com.tomek.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class AdminController {

    PostService postService;
    WriterService writerService;

    @Autowired
    public AdminController(PostService postService, WriterService writerService) {
        this.postService = postService;
        this.writerService = writerService;
    }

    @RequestMapping("/admin")
    public String some(Model model){
        model.addAttribute("posts", postService.allPosts());
        return "admin/admin";
    }

    @RequestMapping("/admin/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        postService.deletePostById(id);
        return "redirect:/admin";
    }

    @RequestMapping("/login")
    public String login() {
        return "login_register/login";
    }

    @RequestMapping("/register")
    public String register() {

        return "login_register/register";
    }


}
