package com.migrator;

import com.migrator.auth.SpotifyAuth;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("        SOUNDBRIDGE");
        System.out.println("================================");

        SpotifyAuth.authenticate();

    }
}
