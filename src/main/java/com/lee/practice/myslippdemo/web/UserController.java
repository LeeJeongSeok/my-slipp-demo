package com.lee.practice.myslippdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @PostMapping("/create")
    public String create(String userId, String password, String name, String email) {
        System.out.println(userId);
        return "welcome";
    }
}
