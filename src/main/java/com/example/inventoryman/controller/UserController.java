package com.example.inventoryman.controller;

import com.example.inventoryman.dto.UserRegistrationDto;
import com.example.inventoryman.model.Item;
import com.example.inventoryman.model.User;
import com.example.inventoryman.repository.UserRepository;
import com.example.inventoryman.service.ItemService;
import com.example.inventoryman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
//@RequestMapping("/registration")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;



    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@Valid @ModelAttribute("user") User user, BindingResult br) {
        if (br.hasErrors()) {
            return "registration";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.save(user);
            return "redirect:/registration?success";
        }

    }
}






















    /*@GetMapping("/test")
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers", itemService.getAllUsers());
        return "indexx";

    }

    @GetMapping("/showNewUserForm")
    public String showNewItemForm(Model model) {
        //System.out.println("HEllllloooooo");
        User user = new User();
        model.addAttribute("user", user);
        return "login";


    }

    @PostMapping("/do_register")
    public String saveItem(@Valid @ModelAttribute("item") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        } else {
            System.out.println("User" + user);
            //System.out.println("Heeeeeeeeeellllllllllllllllllllloooooo");
            itemService.saveUser(user);
            return "redirect:/";
        }

    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        this.itemService.deleteUserById(id);
        return "redirect:/test";
    }*/










