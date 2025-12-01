package com.automation.qa.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigurationManager - Singleton class for managing configuration properties
 * Loads properties from config.properties file
 */
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Properties properties;

    private ConfigurationManager() {
        properties = new Properties();
        loadProperties();
    }

    /**
     * Get singleton instance of ConfigurationManager
     * @return ConfigurationManager instance
     */
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    /**
     * Load properties from config.properties file
     */
    private void loadProperties() {
        try {
            String configPath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
            FileInputStream fileInputStream = new FileInputStream(configPath);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("Error loading config.properties: " + e.getMessage());
        }
    }

    /**
     * Get property value by key
     * @param key property key
     * @return property value
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get property value by key with default value
     * @param key property key
     * @param defaultValue default value if key not found
     * @return property value or default value
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}

