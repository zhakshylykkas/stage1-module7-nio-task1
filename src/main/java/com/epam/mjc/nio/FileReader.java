package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try {
            Path path = file.toPath();

            try (var linesStream = Files.lines(path)) {
                linesStream.forEach(line -> {
                    String[] arr = line.split(": ");

                    if (arr.length == 2) {
                        String key = arr[0];
                        String value = arr[1];

                        switch (key) {
                            case "Name":
                                profile.setName(value);
                                break;
                            case "Age":
                                profile.setAge(Integer.parseInt(value));
                                break;
                            case "Email":
                                profile.setEmail(value);
                                break;
                            case "Phone":
                                profile.setPhone(Long.parseLong(value));
                                break;
                            default:
                                break;
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return profile;
    }
}
