package org.example.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchProcessor {
    private static final String NULL_VALUE = "NULL";
    Map<String, Integer> goalsScored = new HashMap<>();

    public static void main(String[] args) {
        String inputFileName = "matches.txt";
        String outputTeamFileName = "FC Augsburg.txt";
        String outputStadiumFileName = "Mercedes-Benz Arena.txt";
        String outputWinnersFileName = "winners.txt";
        String outputTableFileName = "table.txt";
        processMatches(inputFileName, outputTeamFileName, outputStadiumFileName, outputWinnersFileName,
                outputTableFileName);
    }

    private static void processMatches(String inputFileName, String outputTeamFileName, String outputStadiumFileName,
                                       String outputWinnersFileName, String outputTableFileName) {
        List<String> matcheDraw = new ArrayList<>();
        List<String> matcheVictory = new ArrayList<>();
        List<String> matcheLoss = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             FileWriter teamWriter = new FileWriter(outputTeamFileName);
             FileWriter stadiumWriter = new FileWriter(outputStadiumFileName);
             FileWriter winnersWriter = new FileWriter(outputWinnersFileName);
             FileWriter tableWriter = new FileWriter(outputTableFileName)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",\\s*");
                if (data.length >= 8) {
                    String year = data[0];
                    String month = data[1];
                    String day = data[2];
                    String firstTeam = data[3];
                    String firstTeamCount = data[4];
                    String secondTeam = data[5];
                    String watchers = data[6];
                    String stadium = data[7];

                    String[] scores = firstTeamCount.split(":");
                    int firstTeamGoals = Integer.parseInt(scores[0].trim());
                    int secondTeamGoals = Integer.parseInt(scores[1].trim());

                    if ("FC Augsburg".equalsIgnoreCase(firstTeam) || "FC Augsburg".equalsIgnoreCase(secondTeam)) {
                        String matchDetails = String.format("%-2s/%-2s/%-4s сыграли команды: %-24s - %-24s со счетом %-3s\n",
                                day, month, year, firstTeam, secondTeam, firstTeamCount);
                        teamWriter.write(matchDetails);
                    }
                    if ("Mercedes-Benz Arena".equalsIgnoreCase(stadium)) {
                        String matchDetails = String.format("%-2s/%-2s/%-4s сыграли команды: %-9s - %-19s со счетом %-3s на стадионе %s\n",
                                day, month, year, firstTeam, secondTeam, firstTeamCount, stadium);
                        stadiumWriter.write(matchDetails);
                    }
                    if (firstTeamGoals >= secondTeamGoals) {
                        if (firstTeamGoals == secondTeamGoals) {
                            String matchDetails = String.format("%-2s/%-2s/%-4s сыграли команды: %-24s - %-24s со счетом %-3s ничья\n",
                                    day, month, year, firstTeam, secondTeam, firstTeamCount);
                            matcheDraw.add(matchDetails);
                        } else {
                            String matchDetails = String.format("%-2s/%-2s/%-4s команда: %-24s победила команду: %-24s со счетом %-3s\n",
                                    day, month, year, firstTeam, secondTeam, firstTeamCount);
                            matcheVictory.add(matchDetails);
                        }
                    } else {
                        String matchDetails = String.format("%-2s/%-2s/%-4s команда: %-24s проиграла команде: %-24s со счетом %-3s\n",
                                day, month, year, firstTeam, secondTeam, firstTeamCount);
                        matcheLoss.add(matchDetails);
                    }

                }
            }
            for (String str : matcheDraw) {
                winnersWriter.write(str);
            }
            for (String str : matcheVictory) {
                winnersWriter.write(str);
            }
            for (String str : matcheLoss) {
                winnersWriter.write(str);
            }


            System.out.println("Обработка завершена. Файлы созданы: " +
                    outputTeamFileName + ", " +
                    outputStadiumFileName + ", " +
                    outputWinnersFileName + ", " +
                    outputTableFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
