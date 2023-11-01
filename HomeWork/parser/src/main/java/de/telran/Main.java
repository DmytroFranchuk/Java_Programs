package de.telran;

public class Main {
    public static void main(String[] args) {

        CommandLineParser commandLineParser = new CommandLineParser(args);
        commandLineParser.parseArguments();
    }
}