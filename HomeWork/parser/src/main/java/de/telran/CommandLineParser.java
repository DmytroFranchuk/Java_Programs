package de.telran;

import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {

    private final String[] args;
    private String sortMode = "-a";
    private String dataType = null;
    private String outputFileName = null;
    private List<String> inputFiles = new ArrayList<>();

    public CommandLineParser(String[] args) {
        this.args = args;
    }

    public void parseArguments() {
        try {

            if (args.length < 3) {
                throw new IllegalArgumentException("Not enough arguments");
            }
            if (!(args[0].equals("-a") || args[0].equals("-d") || args[0].equals("-s") || args[0].equals("-i"))) {
                throw new IllegalArgumentException("Invalid parameters");
            }
            if ((args[0].equals("-s") && args[1].equals("-s")) || (args[0].equals("-i") && args[1].equals("-i")) ||
                    (args[0].equals("-s") && args[1].equals("-i")) || (args[0].equals("-i") && args[1].equals("-s"))) {
                throw new IllegalArgumentException("Invalid parameters");
            }

            int arg = 0;
            if (args[arg].equals("-a") || args[arg].equals("-d")) {
                sortMode = args[arg];
                arg++;
            }
            if (args[arg].equals("-s") || args[arg].equals("-i")) {
                dataType = args[arg];
                arg++;
            }
            if (outputFileName == null) {
                outputFileName = args[arg];
                arg++;
            }
            while (arg < args.length) {
                inputFiles.add(args[arg]);
                arg++;
            }

//            if () {
//
//            }
            if (dataType == null || (!dataType.equals("-s") && !dataType.equals("-i"))) {
                throw new IllegalArgumentException("Data type (-s or -i) is required");
            }
            if (outputFileName == null) {
                throw new IllegalArgumentException("Output file name is required");
            }
            if (inputFiles.isEmpty()) {
                throw new IllegalArgumentException("No input file parameter");
            }

            System.out.println("Sorting mode: " + sortMode);
            System.out.println("Data type: " + dataType);
            System.out.println("Output file name: " + outputFileName);
            System.out.println("Input files: " + inputFiles);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Use: <-sort mode> <-data type> <output_file_name> [input_files]");
        }
    }
}
