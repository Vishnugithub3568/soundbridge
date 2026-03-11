package com.migrator;

import com.migrator.export.JsonImporter;
import com.migrator.export.MatchExporter;
import com.migrator.model.Song;
import com.migrator.youtube.YouTubeMatcher;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("SoundBridge matching songs...");

        List<Song> songs = JsonImporter.importPlaylist();

        List<String> videoIds = YouTubeMatcher.matchSongs(songs);

        MatchExporter.exportMatches(songs, videoIds);
    }
}
