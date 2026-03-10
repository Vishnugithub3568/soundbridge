package com.migrator;

import com.migrator.auth.SpotifyAuth;
import com.migrator.spotify.SpotifyClient;
import com.migrator.spotify.PlaylistParser;
import com.migrator.export.JsonExporter;
import com.migrator.model.Song;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("SoundBridge starting...");

        String token = SpotifyAuth.getAccessToken();

        String searchJson = SpotifyClient.searchTrack(token, "Adele");

        List<Song> songs = PlaylistParser.parseSongs(searchJson);

        System.out.println("Songs extracted: " + songs.size());

        JsonExporter.exportPlaylist("Spotify Playlist", songs);

    }
}
