package com.visu.tutorial.auth.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")public class ResourceController {

    @RequestMapping
    public Object getInfo() {
        return "success";
    }
}