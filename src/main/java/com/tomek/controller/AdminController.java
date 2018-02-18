package com.tomek.controller;

import com.tomek.domain.Post;
import com.tomek.domain.observer.PostObserver;
import com.tomek.domain.observer.SingleNotifier;
import com.tomek.service.PostObserverService;
import com.tomek.service.PostService;
import com.tomek.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@Secured({"ROLE_ADMIN"})
public class AdminController {

    PostService postService;
    WriterService writerService;
    PostObserverService postObserverService;

    @Autowired
    public AdminController(PostService postService, WriterService writerService, PostObserverService postObserverService) {
        this.postService = postService;
        this.writerService = writerService;
        this.postObserverService = postObserverService;
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

//    @RequestMapping("/addPost")
//    public String addPost() {
//        return "admin/addPost";
//    }


    @RequestMapping("/admin/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("writers", writerService.allWritersById());
        return "admin/addPost";
    }


    @RequestMapping( value = "/admin/save", method = RequestMethod.POST )
    public String save(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("writers", writerService.allWritersById());
            return "admin/addPost";
        } else {
            Post savedPost = postService.save(post);
            System.out.println(savedPost.toString());
            return "redirect:/admin/";
        }
    }
}
