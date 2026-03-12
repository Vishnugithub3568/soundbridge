package com.migrator.youtube;

import com.migrator.model.Song;
import com.migrator.utils.ConsoleLogger;

import java.util.ArrayList;
import java.util.List;

public class YouTubeMatcher {

    public static List<String> matchSongs(List<Song> songs) {

        List<String> videoIds = new ArrayList<>();

        for (Song song : songs) {

            String query = song.getTitle() + " " + song.getArtist();

            ConsoleLogger.info("Searching YouTube for: " + query);

            String videoId = YouTubeSearch.searchVideo(query);

            ConsoleLogger.info("Matched video ID: " + videoId);
            ConsoleLogger.info("------------------------");

            videoIds.add(videoId);
        }

        return videoIds;
    }
}
