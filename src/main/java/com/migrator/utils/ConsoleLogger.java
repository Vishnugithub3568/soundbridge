package com.migrator.utils;

import java.time.LocalDateTime;

public class ConsoleLogger {

    public static void info(String message) {
        System.out.println("[INFO] " + LocalDateTime.now() + " - " + message);
    }

    public static void error(String message) {
        System.err.println("[ERROR] " + LocalDateTime.now() + " - " + message);
    }

}
