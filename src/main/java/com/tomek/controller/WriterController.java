package com.tomek.controller;

import com.tomek.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriterController {

    private WriterService writerService;

    @Autowired
    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @RequestMapping("/tom")
    public String writerName(Model model){
        model.addAttribute("writer", writerService.writerByName("Tomek"));
        return "post/postPage";
    }

    @RequestMapping("/writers")
    public String allWritesById(Model model) {
        model.addAttribute("admin", writerService.allWritersById());
        return "admin/admin";
    }
}
