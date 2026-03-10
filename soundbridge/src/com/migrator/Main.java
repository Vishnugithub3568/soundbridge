package com.migrator;

import com.migrator.auth.SpotifyAuth;

public class Main {

    public static void main(String[] args) {

        System.out.println("SoundBridge starting...");

        String token = SpotifyAuth.getAccessToken();

        System.out.println("Spotify Access Token:");
        System.out.println(token);

    }
}
