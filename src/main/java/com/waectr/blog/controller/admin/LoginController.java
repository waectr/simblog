package com.waectr.blog.controller.admin;

import com.waectr.blog.service.UserService;
import com.waectr.blog.service.model.User;
import com.waectr.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/admin")
public class LoginController  {

    @Autowired
    UserService userService;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(username);
        password=MD5Util.EncodeByMd5(password);
        User user = userService.checkUser(username, password);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名和密码不正确");
            return "redirect:admin/login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("aaaaaa");
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
