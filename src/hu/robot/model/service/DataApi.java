package hu.robot.model.service;

import hu.robot.model.domain.Program;

import java.util.List;

public class DataApi {

    private final FileReader fileReader;
    private final DataParser dataParser;

    public DataApi(FileReader fileReader, DataParser dataParser) {
        this.fileReader = fileReader;
        this.dataParser = dataParser;
    }

    public List<Program> getData(String input) {
        return dataParser.parse(fileReader.read(input));
    }
}
