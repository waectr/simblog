package com.waectr.blog.controller;

import com.waectr.blog.handler.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @RequestMapping("/test")
//    @ResponseBody
    public String test(){
        throw new NotFoundException();
    }
}
