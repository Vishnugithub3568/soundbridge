package com.migrator.youtube;

import com.migrator.model.Song;

import java.util.List;

public class YouTubeMatcher {

    public static void matchSongs(List<Song> songs) {

        for (Song song : songs) {

            String query = song.getTitle() + " " + song.getArtist();

            System.out.println("Searching YouTube for: " + query);

            String videoId = YouTubeSearch.searchVideo(query);

            System.out.println("Matched Video ID: " + videoId);
            System.out.println("--------------------------------");

        }
    }
}
