package com.migrator.spotify;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migrator.model.Song;
import com.migrator.utils.StringMatcher;

import java.util.ArrayList;
import java.util.List;

public class PlaylistParser {

    public static List<Song> parseSongs(String jsonData) {

        List<Song> songs = new ArrayList<>();

        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonData);

            JsonNode items = root.path("tracks").path("items");

            for (JsonNode item : items) {

                String title;
                String artist;
                
                // Handle both playlist format (with "track" wrapper) and search format
                JsonNode trackNode = item.path("track");
                if (trackNode.isMissingNode()) {
                    // Search API format - direct track data
                    trackNode = item;
                }

                String rawTitle = trackNode.path("name").asText();
                title = StringMatcher.cleanTitle(rawTitle);
                
                JsonNode artistsNode = trackNode.path("artists");
                if (artistsNode.isArray() && artistsNode.size() > 0) {
                    artist = artistsNode.get(0).path("name").asText();
                } else {
                    artist = "Unknown";
                }

                Song song = new Song(title, artist, "Unknown", 0);
                songs.add(song);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }
}
