package org.example.task2;

import org.example.task2.exceptions.ParserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandLineParserTest {

    @Test
    void parseArgumentsTestValidArguments() {
        String[] validArgs = {"-a", "-s", "output.txt", "input1.txt", "input2.txt"};
        assertDoesNotThrow(() -> CommandLineParser.parseArguments(validArgs));
    }

    @Test
    public void parseArgumentsTestNotEnoughArguments() {
        String[] invalidArgs = {"-a", "-s"};
        assertThrows(ParserException.class, () -> CommandLineParser.parseArguments(invalidArgs));
    }

    @Test
    public void parseArgumentsTestInvalidParameters() {
        String[] invalidArgs = {"-x", "-s", "output.txt", "input.txt"};
        assertThrows(ParserException.class, () -> CommandLineParser.parseArguments(invalidArgs));
    }

    @Test
    public void parseArgumentsTestDuplicateSortType() {
        String[] invalidArgs = {"-a", "-a", "output.txt", "input.txt"};
        assertThrows(ParserException.class, () -> CommandLineParser.parseArguments(invalidArgs));
    }

    @Test
    public void parseArgumentsTestInvalidDuplicateType() {
        String[] invalidArgs = {"-s", "-i", "output.txt", "input.txt"};
        assertThrows(ParserException.class, () -> CommandLineParser.parseArguments(invalidArgs));
    }

    @Test
    public void parseArgumentsTestEmptyInputFiles() {
        String[] invalidArgs = {"-a", "-s", "output.txt"};
        assertThrows(ParserException.class, () -> CommandLineParser.parseArguments(invalidArgs));
    }

    @Test
    public void parseArgumentsTestNullInputFiles() {
        String[] invalidArgs = {"-a", "-s", "output.txt", null};
        assertThrows(ParserException.class, () -> CommandLineParser.parseArguments(invalidArgs));
    }

    @Test
    public void parseArgumentsTestEmptySortMode() {
        String[] invalidArgs = {"", "-s", "output.txt", "input.txt"};
        assertThrows(ParserException.class, () -> CommandLineParser.parseArguments(invalidArgs));
    }
}