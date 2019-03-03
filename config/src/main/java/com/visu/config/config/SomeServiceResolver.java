package com.visu.config.config;

import com.visu.config.service.IdleSomeServiceImpl;
import com.visu.config.service.SomeService;
import com.visu.config.service.SomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SomeServiceResolver {

    @Autowired
    private SomeConfiguration someConfiguration;

    @Autowired
    @Qualifier(value = "someServiceImpl")
    private SomeServiceImpl impl;

    @Autowired
    @Qualifier(value = "idleSomeServiceImpl")
    private IdleSomeServiceImpl idle;

    @Bean
    @Primary
    public SomeService getSomeService() {
        return someConfiguration.isFlag() ? impl : idle;
    }
}
