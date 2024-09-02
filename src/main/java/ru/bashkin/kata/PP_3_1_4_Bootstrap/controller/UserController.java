package ru.bashkin.kata.PP_3_1_4_Bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bashkin.kata.PP_3_1_4_Bootstrap.entity.User;
import ru.bashkin.kata.PP_3_1_4_Bootstrap.service.UserService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUserPage(Model model, Principal principal) {
        Optional<User> user1 = userService.findUserByEmail(principal.getName());
        model.addAttribute("user", user1);
        return "user";

    }
}
