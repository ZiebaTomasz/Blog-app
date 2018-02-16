package com.tomek.controller;

import com.tomek.domain.Post;
import com.tomek.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/")
    public String allPosts(Model model) {
        model.addAttribute("posts", postService.allPosts());
        return "post/posts";
    }


//    @RequestMapping("/cont")
//    public String postContent(Model model) {
////        model.addAttribute()
//        return "post/postContent";
//    }

    @RequestMapping("/post/{post}")
    public String onePost(@PathVariable(value = "post") Long id, Model model) {
        model.addAttribute("post", postService.postById(id));
        return "post/postContent";
    }

    @RequestMapping("/edit/{post}")
    public String editPost(@PathVariable(value = "post") Long id, Model model) {
        model.addAttribute("post", postService.postById(id));
        return "post/postContent";
    }

    @RequestMapping("/postWriter/{writerId}")
    public String allPostsByWriterId(@PathVariable(value = "writerId") Long id, Model model) {
        model.addAttribute("posts", postService.postById(id));
        return "post/posts";
    }
}
