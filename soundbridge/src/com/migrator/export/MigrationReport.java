package com.migrator.export;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;

public class MigrationReport {

    public static void generateReport() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(new File("../data/youtube_matches.json"));

            FileWriter writer = new FileWriter("../data/migration_report.txt");

            writer.write("Spotify → YouTube Migration Report\n\n");

            for (JsonNode node : root) {

                String title = node.path("title").asText();
                String artist = node.path("artist").asText();
                String videoId = node.path("videoId").asText();

                String url = "https://www.youtube.com/watch?v=" + videoId;

                writer.write(title + " - " + artist + "\n");
                writer.write(url + "\n\n");
            }

            writer.close();

            System.out.println("Migration report generated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
