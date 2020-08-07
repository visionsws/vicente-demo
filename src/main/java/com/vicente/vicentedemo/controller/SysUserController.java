package com.vicente.vicentedemo.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
