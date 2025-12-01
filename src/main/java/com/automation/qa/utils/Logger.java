package com.automation.qa.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger - Simple logging utility for test execution
 * Provides formatted log messages with timestamps
 */
public class Logger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Log info message
     * @param message message to log
     */
    public static void info(String message) {
        System.out.println("[INFO] [" + LocalDateTime.now().format(formatter) + "] " + message);
    }

    /**
     * Log error message
     * @param message message to log
     */
    public static void error(String message) {
        System.err.println("[ERROR] [" + LocalDateTime.now().format(formatter) + "] " + message);
    }

    /**
     * Log warning message
     * @param message message to log
     */
    public static void warn(String message) {
        System.out.println("[WARN] [" + LocalDateTime.now().format(formatter) + "] " + message);
    }

    /**
     * Log debug message
     * @param message message to log
     */
    public static void debug(String message) {
        System.out.println("[DEBUG] [" + LocalDateTime.now().format(formatter) + "] " + message);
    }
}

