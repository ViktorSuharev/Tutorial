package com.visu.config.controller;

import com.visu.config.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private Service service;

    @Autowired
    public ConfigController(Service service) {
        this.service = service;
    }

    @GetMapping("/lastupd")
    public ResponseEntity getLastUpdate() {
        String lastUpdate = service.getLastUpdate();
        return ResponseEntity.ok().body(lastUpdate);
    }

    @PostMapping("/update")
    public ResponseEntity update() {
        String message = service.update() ? "Successfully updated" : "Update failed";
        return ResponseEntity.ok().body(message);
    }
}
