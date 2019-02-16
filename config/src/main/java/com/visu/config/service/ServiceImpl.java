package com.visu.config.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.function.Supplier;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private Supplier<String> dateFactory;
    private String lastUpdate;

    @Autowired
    public ServiceImpl(Supplier<String> dateFactory) {
        this.dateFactory = dateFactory;
    }

    @PostConstruct
    public void init() throws Exception {
        update();
    }

    @Override
    public boolean update() {
        try {
            lastUpdate = dateFactory.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getLastUpdate() {
        return "Last update was " + lastUpdate;
    }
}
