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


    /*@ModelAttribute("user")
    public User user() {
        return new User();
    }*/

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




     /*@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }*/

    /*@GetMapping
    public String showRegistrationForm() {
        return "registration";
    }*/

    /*@PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user")UserRegistrationDto registrationDto, BindingResult br){
    if(br.hasErrors()){
            return "registration";
        }
        else {
            userService.save(registrationDto);
            return "redirect:/registration?success";
        }*/




















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





 /*@GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }*/

/*@GetMapping("/login")
    public String home(Model model){
       // model.addAttribute("listUsers",listUsers);
        return "login";
    }*/
    /*@GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user",new User());
        // model.addAttribute("listUsers",listUsers);
        return "signup";
    }
    @PostMapping("/do_register")
    public  String registerUser(@ModelAttribute("user") User user, Model model)
    {

        System.out.println("User" +user);
        model.addAttribute("user",user);
        this.repos.save(user);
        return "signup";
    }*/

    /*@GetMapping("/tes")
    @ResponseBody
    public String test() {
        User user = new User();
        user.setName("Ambika");
        user.setEmail("ambikagupta18@gmail.com");
        user.setPhonenumber("1234567890");
        user.setPassword("abcd");
        repos.save(user);
        return "working";
    }*/


