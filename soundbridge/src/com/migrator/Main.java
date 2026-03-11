package com.migrator;

import com.migrator.export.JsonImporter;
import com.migrator.model.Song;
import com.migrator.youtube.YouTubeMatcher;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("SoundBridge starting YouTube matching...");

        List<Song> songs = JsonImporter.importPlaylist();

        System.out.println("Songs loaded: " + songs.size());

        YouTubeMatcher.matchSongs(songs);

    }
}
