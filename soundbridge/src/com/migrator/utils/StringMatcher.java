package com.migrator.utils;

public class StringMatcher {

    public static String cleanTitle(String title) {

        if (title == null) {
            return "";
        }

        // remove text inside parentheses
        title = title.replaceAll("\\(.*?\\)", "");

        // remove text inside brackets
        title = title.replaceAll("\\[.*?\\]", "");

        // remove common unwanted words
        title = title.replaceAll("(?i)remastered", "");
        title = title.replaceAll("(?i)live", "");
        title = title.replaceAll("(?i)official video", "");

        // remove extra spaces
        title = title.trim().replaceAll("\\s+", " ");

        return title;
    }
}
