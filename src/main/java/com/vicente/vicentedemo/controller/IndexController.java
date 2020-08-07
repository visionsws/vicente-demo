package com.vicente.vicentedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    /**
     * 跳转首页
     */
    @GetMapping("")
    public void index1(HttpServletResponse response){
        //内部重定向
        try {
            response.sendRedirect("/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "index";
    }

    @RequestMapping("/form")
    public void form(HttpServletResponse response) {
        //内部重定向
        try {
            response.sendRedirect("/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/loginError")
    @ResponseBody
    public String loginError() {
        return "loginError";
    }
}
