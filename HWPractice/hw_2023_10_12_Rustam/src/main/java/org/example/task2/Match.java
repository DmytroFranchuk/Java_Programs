package org.example.task2;

import java.util.Objects;

public class Match {
    private String year;
    private String month;
    private String day;
    private String firstTeam;
    private String firstTeamCount;
    private String secondTeam;
    private String watchers;
    private String stadium;

    public Match(String year, String month, String day, String firstTeam, String firstTeamCount, String secondTeam, String watchers, String stadium) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.firstTeam = firstTeam;
        this.firstTeamCount = firstTeamCount;
        this.secondTeam = secondTeam;
        this.watchers = watchers;
        this.stadium = stadium;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getFirstTeamCount() {
        return firstTeamCount;
    }

    public void setFirstTeamCount(String firstTeamCount) {
        this.firstTeamCount = firstTeamCount;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public String getWatchers() {
        return watchers;
    }

    public void setWatchers(String watchers) {
        this.watchers = watchers;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(year, match.year) && Objects.equals(month, match.month) && Objects.equals(day, match.day) && Objects.equals(firstTeam, match.firstTeam) && Objects.equals(firstTeamCount, match.firstTeamCount) && Objects.equals(secondTeam, match.secondTeam) && Objects.equals(watchers, match.watchers) && Objects.equals(stadium, match.stadium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day, firstTeam, firstTeamCount, secondTeam, watchers, stadium);
    }

    @Override
    public String toString() {
        return "Match{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", firstTeam='" + firstTeam + '\'' +
                ", firstTeamCount='" + firstTeamCount + '\'' +
                ", secondTeam='" + secondTeam + '\'' +
                ", watchers='" + watchers + '\'' +
                ", stadium='" + stadium + '\'' +
                '}';
    }
}
