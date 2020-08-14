package com.vicente.vicentedemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/auth/admin")
    @PreAuthorize("hasAuthority('admin')")
    public String authenticationAdmin() {
        return "您拥有admin权限，可以查看";
    }

    @GetMapping("/auth/user")
    @PreAuthorize("hasAuthority('user')")
    public String authenticationUser() {
        return "您拥有user权限，可以查看";
    }
}
