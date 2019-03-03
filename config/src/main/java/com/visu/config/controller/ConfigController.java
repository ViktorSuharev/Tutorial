package com.visu.config.controller;

import com.visu.config.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/some")
public class ConfigController {

    private SomeService someService;

    @Autowired
    public ConfigController(SomeService someService) {
        this.someService = someService;
    }

    @GetMapping("/stuff")
    public ResponseEntity getLastUpdate() {
        String someStuff = someService.getSomeStuff();
        return ResponseEntity.ok().body(someStuff);
    }
}
