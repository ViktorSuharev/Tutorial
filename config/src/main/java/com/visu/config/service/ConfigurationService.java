package com.visu.config.service;

import com.visu.config.model.SomeConfiguration;

public interface ConfigurationService {

    String getLastUpdate();

    boolean update();

    SomeConfiguration getSomeConfiguration();
}
