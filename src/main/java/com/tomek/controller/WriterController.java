package com.tomek.controller;

import com.tomek.domain.Writer;
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

//    @RequestMapping("/writer/{id}")
//    public String writerName(@PathVariable(value = "id")Long id, Model model){
//        model.addAttribute("writers", writerService.writerById(id));
//        return "writer/writers";
//    }

    @RequestMapping("/writers")
    public String allWritesById(Model model) {
        model.addAttribute("writers", writerService.allWritersById());
        return "writer/writers";
    }

    @RequestMapping("/writer/newWriter")
    public String newWriter(Model model) {

        model.addAttribute("writer",new Writer());
        return "writer/writerRegistration";
    }


}
