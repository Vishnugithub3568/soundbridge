package com.migrator.auth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpotifyAuth {

    public static String getAccessToken() {

        try {

            String clientId = SpotifyConfig.CLIENT_ID;
            String clientSecret = SpotifyConfig.CLIENT_SECRET;

            String credentials = clientId + ":" + clientSecret;
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

            URL url = new URL("https://accounts.spotify.com/api/token");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setDoOutput(true);

            String body = "grant_type=client_credentials";

            OutputStream os = connection.getOutputStream();
            os.write(body.getBytes());
            os.flush();
            os.close();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response.toString());

            return json.get("access_token").asText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
