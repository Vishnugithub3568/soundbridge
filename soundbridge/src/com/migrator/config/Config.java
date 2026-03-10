package com.migrator.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private static Map<String, String> properties = new HashMap<>();

    static {
        loadEnv();
    }

    private static void loadEnv() {
        try {
            File envFile = new File(".env");
            if (envFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(envFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.isEmpty() && !line.startsWith("#")) {
                        String[] parts = line.split("=", 2);
                        if (parts.length == 2) {
                            properties.put(parts[0].trim(), parts[1].trim());
                        }
                    }
                }
                reader.close();
            } else {
                System.err.println("Warning: .env file not found!");
            }
        } catch (IOException e) {
            System.err.println("Error loading .env file: " + e.getMessage());
        }
    }

    public static String getSpotifyClientId() {
        return properties.getOrDefault("SPOTIFY_CLIENT_ID", "");
    }

    public static String getSpotifyClientSecret() {
        return properties.getOrDefault("SPOTIFY_CLIENT_SECRET", "");
    }

    public static String get(String key) {
        return properties.getOrDefault(key, "");
    }
}
