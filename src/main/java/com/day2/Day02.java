package com.day2;

import java.io.IOException;

import com.InputFetcher;

public class Day02 {
    public static void main(String[] args) throws IOException {
        String input =  InputFetcher.readTextFile("src/main/java/com/day2/input.txt"); 
        int[] totalScore = getTotalScore(input);
        System.out.println(totalScore[0]);
        System.out.println(totalScore[1]);
    }

    private static int[] getTotalScore(String input) {
        int[] totalScore = new int[] {0, 0};
        input.lines().forEach(
            line -> {
                int roundScorePart1 = playRoundPart1(line);
                int roundScorePart2 = playRoundPart2(line);
                totalScore[0] += roundScorePart1; 
                totalScore[1] += roundScorePart2;  
            }
        );
        return totalScore;
    }

    private static int playRoundPart1(String line) {
        switch (line) {
            case "A X":
                return 4;
            case "A Y":
                return 8;
            case "A Z":
                return 3;
            case "B X":
                return 1;
            case "B Y":
                return 5;
            case "B Z":
                return 9;
            case "C X":
                return 7;
            case "C Y":
                return 2;
            case "C Z":
                return 6;
        }
        return 0;
    }

    private static int playRoundPart2(String line) {
        switch (line) {
            case "A X":
                return 3;
            case "A Y":
                return 4;
            case "A Z":
                return 8;
            case "B X":
                return 1;
            case "B Y":
                return 5;
            case "B Z":
                return 9;
            case "C X":
                return 2;
            case "C Y":
                return 6;
            case "C Z":
                return 7;
        }
        return 0;
    }
    
}
