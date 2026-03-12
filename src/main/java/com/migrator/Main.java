package com.migrator;

import com.migrator.export.JsonImporter;
import com.migrator.export.MigrationReport;
import com.migrator.model.Song;
import com.migrator.youtube.YouTubeMatcher;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== SoundBridge Menu =====");
            System.out.println("1 Match songs on YouTube");
            System.out.println("2 Generate migration report");
            System.out.println("3 Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {

                List<Song> songs = JsonImporter.importPlaylist();
                YouTubeMatcher.matchSongs(songs);

            }

            else if (choice == 2) {

                MigrationReport.generateReport();

            }

            else if (choice == 3) {

                System.out.println("Exiting SoundBridge.");
                break;

            }

            else {

                System.out.println("Invalid option.");

            }

        }

        scanner.close();
    }
}
