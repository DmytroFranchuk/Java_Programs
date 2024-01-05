package org.example.task2;

import org.example.task2.exceptions.ParserException;

import java.util.Arrays;

public class CommandLineParser {
    private CommandLineParser() {
    }

    public static void parseArguments(String[] args) throws ParserException {
        if (args == null || Arrays.asList(args).contains(null)) {
            throw new ParserException("Invalid arguments - contains null");
        }
        if (args.length < 3) {
            throw new ParserException("Not enough arguments");
        }
        if (!(args[0].equals("-a") || args[0].equals("-d") || args[0].equals("-s") || args[0].equals("-i"))) {
            throw new ParserException("Invalid parameters");
        }
        if ((args[0].equals("-s") && args[1].equals("-s")) || (args[0].equals("-i") && args[1].equals("-i")) ||
                (args[0].equals("-s") && args[1].equals("-i")) || (args[0].equals("-i") && args[1].equals("-s"))) {
            throw new ParserException("Invalid parameters");
        }

        String[] validSortArgs = {"-a", "-d"};
        String[] validTypeArgs = {"-s", "-i"};
        ResultParser result = new ResultParser();
        int arg = 0;
        if (Arrays.asList(validSortArgs).contains(args[arg])) {
            result.setSortMode(args[arg++]);
        }
        if (Arrays.asList(validTypeArgs).contains(args[arg])) {
            result.setDataType(args[arg++]);
        }
        if (result.getOutputFileName() == null) {
            result.setOutputFileName(args[arg++]);
        }
        while (arg < args.length) {
            result.setInputFiles(args[arg++]);
        }
        result.isResultParserCorrect();
    }
}
