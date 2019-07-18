package com.demo.ss.services;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Stateless
public class ConfigurationServiceImpl implements ConfigurationService {

    private static final String PROPERTIES_FILE = "config.properties";
    private Properties properties;

    @PostConstruct
    public void init() {
        properties = new Properties();

        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (final InputStream input = loader.getResourceAsStream(PROPERTIES_FILE)) {

            if (input == null) {
                System.out.println("Sorry, unable to find:" + PROPERTIES_FILE);
                return;
            }

            //load a properties file from class path, inside static method
            properties.load(input);

        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getConfigurationStringValue(final String key) {
        if (System.getenv(key) != null) {
            return System.getenv(key);
        }

        return properties.getProperty(key);
    }
}