package com.visu.config.service;

import com.visu.config.config.SomeConfiguration;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {

    private SomeConfiguration someConfiguration;

    public SomeServiceImpl(SomeConfiguration someConfiguration) {
        this.someConfiguration = someConfiguration;
    }

    @Override
    public String getSomeStuff() {
        return someConfiguration.getProperty();
    }
}
