package com.waectr.blog.controller;

import com.waectr.blog.service.BlogService;
import com.waectr.blog.service.TagService;
import com.waectr.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("list",blogService.listAll()); //查所有的文章
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable  Long id, Model model){
        model.addAttribute("blog",blogService.getBlogAndUser(id));
        return "blog";
    }

}
