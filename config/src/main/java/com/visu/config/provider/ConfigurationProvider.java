package com.visu.config.provider;

import com.visu.config.model.SomeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

@Configuration
public class ConfigurationProvider {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Autowired
    private SomeConfiguration someConfiguration;

    @Bean
    public Supplier<String> getDateFactory() {
        return () -> getCurrentDate();
    }

    @Bean
    public Supplier<SomeConfiguration> getSomeConfigurationFactory() {
        return () -> getSomeConfiguration();
    }

    @Bean
    @Scope("prototype")
    public String getCurrentDate() {
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Bean
    @Scope("prototype")
    public SomeConfiguration getSomeConfiguration() {
        return someConfiguration;
    }
}
