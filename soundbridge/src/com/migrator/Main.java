package com.migrator;

import com.migrator.auth.SpotifyAuth;
import com.migrator.spotify.SpotifyClient;

public class Main {

    public static void main(String[] args) {

        System.out.println("SoundBridge starting...");

        String token = SpotifyAuth.getAccessToken();

        System.out.println("Spotify Access Token: " + token);

        if (token != null) {
            System.out.println("\n--- Testing Search API ---");
            String searchResult = SpotifyClient.searchTrack(token, "Hello Adele");

            System.out.println("Search Results:");
            System.out.println(searchResult);
        }

    }
}
