package com.vicente.vicentedemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author weisen
 * @since 2020-08-06
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @RequestMapping("/list")
    public String index() {
        return "list";
    }



    @RequestMapping("/whoim")
    public Object whoIm()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
