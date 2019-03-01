package com.visu.config.controller;

import com.visu.config.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private ConfigurationService configurationService;

    @Autowired
    public ConfigController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping("/lastupd")
    public ResponseEntity getLastUpdate() {
        String lastUpdate = configurationService.getLastUpdate();
        return ResponseEntity.ok().body(lastUpdate);
    }

    @PostMapping("/update")
    public ResponseEntity update() {
        String message = configurationService.update() ? "Successfully updated" : "Update failed";
        configurationService.getSomeConfiguration();
        return ResponseEntity.ok().body(message);
    }
}
