package com.visu.config.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class SomeConfiguration {

    @Value("${property.boolean}")
    private boolean isFlag;

    @Value("${property.string}")
    private String property;
}
