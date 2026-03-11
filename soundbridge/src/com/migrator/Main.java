package com.migrator;

import com.migrator.export.JsonImporter;
import com.migrator.model.Song;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("SoundBridge reading exported playlist...");

        List<Song> songs = JsonImporter.importPlaylist();

        for (Song song : songs) {
            System.out.println(song);
        }

    }
}
