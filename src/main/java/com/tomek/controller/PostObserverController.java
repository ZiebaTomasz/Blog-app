package com.tomek.controller;

import com.tomek.domain.Post;
import com.tomek.domain.observer.PostObserver;
import com.tomek.domain.observer.SingleNotifier;
import com.tomek.service.PostObserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostObserverController {

    private PostObserverService postObserverService;

    @Autowired
    public PostObserverController(PostObserverService postObserverService) {
        this.postObserverService = postObserverService;
    }

    @RequestMapping(value = "/observer/register")
    public String register(Model model){
        model.addAttribute(new PostObserver());
        return "/observer/registerObserver";
    }


    @RequestMapping( value = "/observer/save", method = RequestMethod.POST )
    public String save(@Valid PostObserver postObserver, BindingResult bindingResult, Model model) {

        if( bindingResult.hasErrors() ){
            model.addAttribute("postObserver", postObserverService.getAllObservers());
            return "observer/register";
        } else {
            PostObserver postObservers = postObserverService.save(postObserver);

            return "redirect:/observer/register";
        }
    }

}
