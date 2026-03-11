package com.migrator.export;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.migrator.model.Song;

import java.io.File;
import java.util.List;

public class MatchExporter {

    public static void exportMatches(List<Song> songs, List<String> videoIds) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            ArrayNode array = mapper.createArrayNode();

            for (int i = 0; i < songs.size(); i++) {

                Song song = songs.get(i);
                String videoId = videoIds.get(i);

                ObjectNode node = mapper.createObjectNode();

                node.put("title", song.getTitle());
                node.put("artist", song.getArtist());
                node.put("videoId", videoId);

                array.add(node);
            }

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("../data/youtube_matches.json"), array);

            System.out.println("YouTube matches saved.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
