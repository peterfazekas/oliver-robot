package hu.robot.model.service;

import hu.robot.model.domain.Program;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    private int id;

    public List<Program> parse(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(this::createProgram)
                .collect(Collectors.toList());
    }

    private Program createProgram(String line) {
        return new Program(++id, line);
    }
}
