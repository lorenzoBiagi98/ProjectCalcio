package com.example.ProjectCalcio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 

    @Controller
public class AppController {

    @GetMapping("/")
    public String root(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(){
        return "home.html";
    }

    @GetMapping("/contattaci")
    public String contattaci(){
        return "contatto.html";
    }


}
