package com.matheus.bowling.input.file;

import com.matheus.bowling.input.BowlingInput;
import com.matheus.bowling.input.RollFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler implements BowlingInput {

    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<RollFile> read() {
        List<RollFile> rolls = null;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            rolls = stream.map(this::getRoll).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rolls;
    }

    @Override
    public void write() {

    }

    private RollFile getRoll(String line) {
        String[] args = line.trim().split("\\s+");
        RollFile roll = new RollFile(args[0], args[1]);

        return roll;
    }
}
