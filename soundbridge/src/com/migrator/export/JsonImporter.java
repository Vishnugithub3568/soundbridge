package com.migrator.export;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migrator.model.Song;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonImporter {

    public static List<Song> importPlaylist() {

        List<Song> songs = new ArrayList<>();

        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(new File("../data/exported_playlist.json"));

            JsonNode songArray = root.path("songs");

            for (JsonNode node : songArray) {

                String title = node.path("title").asText();
                String artist = node.path("artist").asText();

                Song song = new Song(title, artist, "Unknown", 0);

                songs.add(song);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }
}
