package com.day6;

import java.io.IOException;

import com.InputFetcher;

import java.util.Set;
import java.util.stream.Collectors;

public class Day06 {
    private static int position;
    private static int sequenceLength;
    public static void main(String[] args) throws IOException {
        sequenceLength = 14;
        String input = InputFetcher.readTextFile("src/main/java/com/day6/input.txt");
        positionFinder(input);
        System.out.println(position);
    }

    private static void positionFinder(String input){
        for (int i=0; i<input.length(); i++){
            String sequence = input.substring(i, i+sequenceLength);
            Set<Character> charsSet = sequence.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
            if (charsSet.size() == sequenceLength){
                position = i + sequenceLength;
                break;
            }
        }
    }
}