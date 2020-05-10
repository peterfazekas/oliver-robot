package hu.robot.model.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWriter {

    public final String filename;

    public FileWriter(String filename) {
        this.filename = filename;
    }

    public void writeAll(List<String> lines) {
        try {
            Files.write(Paths.get(filename), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
