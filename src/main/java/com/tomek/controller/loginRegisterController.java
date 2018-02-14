package com.tomek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginRegisterController {

    @RequestMapping("/")
    public String home(Model model) {
        return "post/posts";
    }

    @RequestMapping("/index")
    public String some(Model model){
        return "post/index";
    }

}
