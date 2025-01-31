package com.rossacheson.springboot.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("my-login")
    public String myLogin() {
        return "fancy-login";
    }

    @GetMapping("access-denied")
    public String showAccessDeniedPage() {
        return "access-denied";
    }
}
