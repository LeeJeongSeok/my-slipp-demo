package com.lee.practice.myslippdemo.web;

import com.lee.practice.myslippdemo.UserRepository;
import com.lee.practice.myslippdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public String create(User user) {
        System.out.println("User : " + user);
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/user/list";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            System.out.println("Login Failed");
            return "redirect:/users/loginForm";
        }

        if (!password.equals(user.getPassword())) {
            System.out.println("Login Failed");
            return "redirect:/users/loginForm";
        }

        System.out.println("user : " + user);
        session.setAttribute("test-user", user);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.removeAttribute("test-user");

        return "redirect:/";
    }

    @GetMapping("/form")
    public String form() {
        return "/user/form";
    }

    @GetMapping("/{id}/form")
    public String update_form(@PathVariable Long id, Model model, HttpSession session) throws IllegalAccessException {

        Object tempUser = session.getAttribute("test-user");
        if (tempUser == null) {
            return "redirect:/users/loginForm";
        }

        User sessionedUser = (User)tempUser;
        if (!id.equals(sessionedUser.getId())) {
            throw new IllegalAccessException("자신의 정보만 수정할 수 있습니다.");
        }

        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        System.out.println(user);
        return "/user/updateForm";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, User updatedUser, HttpSession session) throws IllegalAccessException {

        Object tempUser = session.getAttribute("test-user");
        if (tempUser == null) {
            return "redirect:/users/loginForm";
        }

        User sessionedUser = (User)tempUser;
        if (!id.equals(sessionedUser.getId())) {
            throw new IllegalAccessException("자신의 정보만 수정할 수 있습니다.");
        }

        User user = userRepository.findById(id).get();
        user.update(updatedUser);
        userRepository.save(user);
        return "redirect:/users";
    }
}
