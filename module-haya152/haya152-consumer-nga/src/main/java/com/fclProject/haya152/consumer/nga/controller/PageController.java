package com.fclProject.haya152.consumer.nga.controller;

import com.fclProject.haya152.consumer.nga.dto.NgaDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @RequestMapping("/default")
    public String selectPage() {
        return "select";
    }

//    @RequestMapping("/show")
//    public String showPage(List<NgaDto> list, Model model) {
//        model.addAttribute("list",list);
//        return "show";
//    }
}
