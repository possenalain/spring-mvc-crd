package com.nalain.controllers;

import com.nalain.domain.User;
import com.nalain.services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/users")
@Getter
@Setter
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("")
    public String listUsers(Model model){
        model.addAttribute("users", userService.listAll());
        return "user/users";
    }

    @RequestMapping("/{id}")
    public String getUser(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "user/user";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "user/userform";
    }

    @RequestMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "user/userform";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveOrUpdate(User user){
        User savedUser = userService.save(user);
        return "redirect:/users/" + savedUser.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/users";
    }
}