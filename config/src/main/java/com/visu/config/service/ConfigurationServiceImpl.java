package com.visu.config.service;

import com.visu.config.model.SomeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.function.Supplier;

@org.springframework.stereotype.Service
public class ConfigurationServiceImpl implements ConfigurationService {

    private Supplier<String> dateFactory;
    private Supplier<SomeConfiguration> someConfigurationFactory;

    private SomeConfiguration someConfiguration;
    private String lastUpdate;

    @Autowired
    public ConfigurationServiceImpl(Supplier<String> dateFactory, Supplier<SomeConfiguration> someConfigurationFactory) {
        this.dateFactory = dateFactory;
        this.someConfigurationFactory = someConfigurationFactory;
    }

    @PostConstruct
    public void init() throws Exception {
        update();
    }

    @Override
    public boolean update() {
        try {
            someConfiguration = someConfigurationFactory.get();
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

    @Override
    public SomeConfiguration getSomeConfiguration() {
        return someConfiguration;
    }
}
