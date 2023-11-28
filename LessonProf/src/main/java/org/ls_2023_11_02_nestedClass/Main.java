package org.ls_2023_11_02_nestedClass;

public class Main {
    public static void main(String[] args) {
        // java -cp target/classes org.ls_02_11_2023_UnitTests.Main -a -i -f1 -f2 -f3 -f4
        CommandLineParser commandLineParser = new CommandLineParser(args);
        commandLineParser.parseArguments();
    }
}