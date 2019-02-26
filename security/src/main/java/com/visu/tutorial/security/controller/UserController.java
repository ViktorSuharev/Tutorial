package com.visu.tutorial.security.controller;

import com.visu.tutorial.security.dao.UserDao;
import com.visu.tutorial.security.model.User;
import com.visu.tutorial.security.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users/me")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> getCurrentUser(@AuthenticationPrincipal UserPrincipal currentUser) {
        User user = userDao.findByUsername(currentUser.getUsername());

        return ResponseEntity.ok(user);
    }

    @GetMapping("/admins/me")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getAdmin(@AuthenticationPrincipal UserPrincipal currentUser) {
        User user = userDao.findByUsername(currentUser.getUsername());

        return ResponseEntity.ok(user);
    }
}
