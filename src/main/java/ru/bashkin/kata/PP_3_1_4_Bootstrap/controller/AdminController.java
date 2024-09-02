package ru.bashkin.kata.PP_3_1_4_Bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bashkin.kata.PP_3_1_4_Bootstrap.entity.User;
import ru.bashkin.kata.PP_3_1_4_Bootstrap.service.UserService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model, Principal principal) {
        model.addAttribute("allUsers", userService.getAll());
        String email = principal.getName();
        Optional<User> user2 = userService.findUserByEmail(email);
        model.addAttribute("user2", user2);
        model.addAttribute("allRoles", userService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user) {

        userService.save(user);
        return "redirect:/admin";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") Long id, Model model) {
        model.addAttribute("allRoles", userService.getAllRoles());
        userService.save(user);

        return "redirect:/admin";
    }
}
