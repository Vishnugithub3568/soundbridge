package com.migrator.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class YouTubeSearch {

    private static boolean isBadMatch(String title) {

        title = title.toLowerCase();

        return title.contains("cover")
            || title.contains("lyrics")
            || title.contains("karaoke")
            || title.contains("live")
            || title.contains("remix");
    }

    public static String searchVideo(String query) {

        try {

            String endpoint =
                    "https://www.googleapis.com/youtube/v3/search"
                    + "?part=snippet"
                    + "&maxResults=5"
                    + "&q=" + query.replace(" ", "%20")
                    + "&type=video"
                    + "&key=" + YouTubeConfig.API_KEY;

            URL url = new URL(endpoint);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.toString());

            JsonNode items = root.path("items");

            for (JsonNode item : items) {

                String videoTitle = item.path("snippet").path("title").asText();
                String videoId = item.path("id").path("videoId").asText();

                if (!isBadMatch(videoTitle)) {

                    return videoId;
                }
            }

            return items.get(0).path("id").path("videoId").asText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

