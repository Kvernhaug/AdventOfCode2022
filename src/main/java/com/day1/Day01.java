package com.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.InputFetcher;

public class Day01 {

    public static void main(String[] args) throws IOException {
        String input =  InputFetcher.readTextFile("src/main/java/com/day1/input.txt"); 
        List<Integer> calorieSums = calorieSumInDescendingOrder(input); 
        System.out.println(calorieSums.get(0));
        Integer topThree = calorieSums.get(0) + calorieSums.get(1) + calorieSums.get(2);
        System.out.println(topThree);
    }

    private static List<Integer> calorieSumInDescendingOrder(String input) {
        List<Integer> calorieSums = new ArrayList<>();
        int[] currentElf = new int[] {0};
        input.lines().forEach(
            line -> {
            if (line.isBlank()) {
                calorieSums.add(currentElf[0]);
                currentElf[0] = 0;
            } else {
                currentElf[0] += Integer.parseInt(line);
            }
            }
        );
        calorieSums.add(currentElf[0]);
        Collections.sort(calorieSums, Collections.reverseOrder());
        return calorieSums;
    }
}
