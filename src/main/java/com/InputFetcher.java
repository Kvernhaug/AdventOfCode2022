package com;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;



public class InputFetcher {
    // Constructor
    public InputFetcher() {

    }

    public static String readTextFile(String pathName) throws IOException {
        Path path = Paths.get(pathName);
        String content = Files.readString(path);
        return content;
    }

    public static List<String> getInputList(String pathName) throws IOException {
        String content = readTextFile(pathName);
        List<String> lines = new ArrayList<>();
        content.lines().forEach(
            line -> {
                lines.add(line);
            }
        );
        return lines;
    }
}
