package com.tomek.controller;

import com.tomek.domain.Post;
import com.tomek.service.NotificationService;
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

@Controller
@Secured({"ROLE_ADMIN"})
public class AdminController {

    PostService postService;
    WriterService writerService;
    PostObserverService postObserverService;
    NotificationService notificationService;

    @Autowired
    public AdminController(PostService postService, WriterService writerService,
                           PostObserverService postObserverService, NotificationService notificationService) {
        this.postService = postService;
        this.writerService = writerService;
        this.postObserverService = postObserverService;
        this.notificationService = notificationService;
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

            try {
                notificationService.sendEmail(savedPost, postObserverService.getAllObservers());
            }catch (Exception e){
                System.out.println("Something went wrong");
            }

            return "redirect:/admin/";
        }
    }
}
