package com.rossacheson.springboot.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("my-login")
    public String myLogin() {
        return "plain-login";
    }
}
