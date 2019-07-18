package com.demo.ss.services;

public interface ConfigurationService {
    String getConfigurationStringValue(final String key);

    String USER_NAME = "USER_NAME";
    String USER_PASS = "USER_PASS";
}

