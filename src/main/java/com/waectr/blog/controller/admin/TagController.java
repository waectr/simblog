package com.waectr.blog.controller.admin;

import com.waectr.blog.service.TagService;
import com.waectr.blog.service.model.Tag;
import com.waectr.blog.service.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public String types(Model model){
        List<Tag> list = tagService.list();
        model.addAttribute("list",list);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(){
        return "admin/tags-input";
    }


    @PostMapping("/tags")
    public String post(Tag tag){
        tagService.saveTag(tag);
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.delete(id);
        return "redirect:/admin/tags";
    }
}
