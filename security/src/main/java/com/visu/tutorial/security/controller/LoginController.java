package com.visu.tutorial.security.controller;

import com.visu.tutorial.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private UserDetailsService loginService;

    @Autowired
    public UserDetailsService getLoginService() {
        return loginService;
    }

    @PostMapping("/")
    public ResponseEntity addNewProject(@RequestBody User user) {
        UserDetails userDetails = loginService.loadUserByUsername(user.getName());
        System.out.println(userDetails);

        return ResponseEntity.ok().build();
    }
}
