package de.telran;

import de.telran.exceptions.ParserException;
import static de.telran.CommandLineParser.parseArguments;

public class Main {
    public static void main(String[] args) {
        try {
            parseArguments(args);
        } catch (ParserException e) {
            System.out.println("Error command line: " + e.getMessage());
            System.out.println("Use: <-sort mode> <-data type> <output_file_name> [input_files]");
        }
    }
}