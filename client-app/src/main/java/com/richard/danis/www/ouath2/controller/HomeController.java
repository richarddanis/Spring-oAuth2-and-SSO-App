package com.richard.danis.www.ouath2.controller;

import com.richard.danis.www.ouath2.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private HelloService helloService;

    public HomeController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public ResponseEntity<String> getMessage() {
        try {
            String message =
                    helloService.getMessage().orElseThrow(() -> new IllegalArgumentException("No message available"));
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
