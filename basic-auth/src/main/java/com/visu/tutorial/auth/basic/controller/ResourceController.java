package com.visu.tutorial.auth.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @RequestMapping("/public/some")
    public Object getPublic() {
        return "public";
    }

    @RequestMapping("/private/read/some")
    public Object getRead() {
        return "read";
    }

    @RequestMapping("/private/exec/some")
    public Object getExec() {
        return "exec";
    }
}