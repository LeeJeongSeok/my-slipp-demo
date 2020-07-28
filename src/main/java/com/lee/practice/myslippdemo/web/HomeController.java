package com.lee.practice.myslippdemo.web;

import com.lee.practice.myslippdemo.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "index";
    }

}
