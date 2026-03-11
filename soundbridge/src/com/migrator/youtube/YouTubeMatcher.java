package com.migrator.youtube;

import com.migrator.model.Song;

import java.util.ArrayList;
import java.util.List;

public class YouTubeMatcher {

    public static List<String> matchSongs(List<Song> songs) {

        List<String> videoIds = new ArrayList<>();

        for (Song song : songs) {

            String query = song.getTitle() + " " + song.getArtist();

            System.out.println("Searching: " + query);

            String videoId = YouTubeSearch.searchVideo(query);

            System.out.println("Matched video: " + videoId);
            System.out.println("------------------------");

            videoIds.add(videoId);
        }

        return videoIds;
    }
}
