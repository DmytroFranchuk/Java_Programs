package de.telran;

import de.telran.exceptions.ParserException;

import java.util.ArrayList;
import java.util.List;

public class ResultParser {
    private String sortMode = "-a";
    private String dataType = null;
    private String outputFileName = null;
    private final List<String> inputFiles = new ArrayList<>();

    public void setSortMode(String sortMode) {
        this.sortMode = sortMode;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void setInputFiles(String nameFile) {
        this.inputFiles.add(nameFile);
    }

    public void isResultParserCorrect() throws ParserException{
        if (dataType == null || (!dataType.equals("-s") && !dataType.equals("-i"))) {
            throw new ParserException("Data type (-s or -i) is required");
        }

        if (outputFileName == null) {
            throw new ParserException("Output file name is required");
        }

        if (inputFiles.isEmpty()) {
            throw new ParserException("No input file parameter");
        }
        System.out.println("Sorting mode: " + sortMode);
        System.out.println("Data type: " + dataType);
        System.out.println("Output file name: " + outputFileName);
        System.out.println("Input files: " + inputFiles);
    }
}
