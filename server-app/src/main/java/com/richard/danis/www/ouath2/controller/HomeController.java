package com.richard.danis.www.ouath2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloMessage() {
        return "from-server-side";
    }
}
