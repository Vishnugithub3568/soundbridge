package com.migrator.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YouTubeSearch {

    public static String searchVideo(String query) {

        try {

            String endpoint =
                    "https://www.googleapis.com/youtube/v3/search"
                    + "?part=snippet"
                    + "&maxResults=1"
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

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

