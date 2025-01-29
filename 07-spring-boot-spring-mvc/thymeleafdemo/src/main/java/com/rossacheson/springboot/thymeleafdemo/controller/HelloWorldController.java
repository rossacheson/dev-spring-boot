package com.rossacheson.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // @RequestMapping("/showForm") // supports all HTTP methods
    @GetMapping("/showForm") // only supports GET
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "hellostudent";
    }

    @RequestMapping("/processFormV2")
    public String processFormV2(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Yo! " + name + "!";
        model.addAttribute("message", result);

        return "hellostudent";
    }

    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String name, Model model) {
        name = name.toUpperCase();
        String result = "Hey friend! " + name + "!";
        model.addAttribute("message", result);

        return "hellostudent";
    }
}
