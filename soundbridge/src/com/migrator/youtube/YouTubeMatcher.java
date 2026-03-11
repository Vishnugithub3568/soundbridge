package com.migrator.youtube;

import com.migrator.model.Song;

import java.util.List;

public class YouTubeMatcher {

    public static void matchSongs(List<Song> songs) {

        for (Song song : songs) {

            String query = song.getTitle() + " " + song.getArtist();

            System.out.println("Searching YouTube for: " + query);

            String result = YouTubeSearch.searchVideo(query);

            System.out.println("Result:");
            System.out.println(result);
            System.out.println("--------------------------------");

        }
    }
}
