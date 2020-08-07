package com.vicente.vicentedemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String error404() {
        return "404";
    }
}
