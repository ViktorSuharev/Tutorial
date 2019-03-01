package com.visu.config.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class SomeConfiguration {

    @Value("${property.boolean}")
    private boolean isFlag;

    @Value("${property.string}")
    private String property;
}
