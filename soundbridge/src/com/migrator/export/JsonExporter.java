package com.migrator.export;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.migrator.model.Song;

import java.io.File;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;

public class JsonExporter {

    public static void exportPlaylist(String playlistName, List<Song> songs) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> playlistMap = new LinkedHashMap<>();
            playlistMap.put("name", playlistName);

            List<Map<String, String>> songList = new ArrayList<>();
            
            for (Song song : songs) {
                Map<String, String> songMap = new LinkedHashMap<>();
                songMap.put("title", song.getTitle());
                songMap.put("artist", song.getArtist());
                songList.add(songMap);
            }

            playlistMap.put("songs", songList);

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("../data/exported_playlist.json"), playlistMap);

            System.out.println("Playlist exported to data/exported_playlist.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
