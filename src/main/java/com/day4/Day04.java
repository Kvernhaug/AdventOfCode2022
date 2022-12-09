package com.day4;

import com.InputFetcher;

import java.io.IOException;
import java.util.List;

public class Day04 {
    private static int nFullyContainedAssignments;
    private static int nOverlappingPairs;
    private static List<String> inputList;
    public static void main(String[] args) throws IOException {
        nFullyContainedAssignments = 0;
        nOverlappingPairs = 0;
        inputList = InputFetcher.getInputList("src/main/java/com/day4/input.txt");
        // Part 1
        findFullyContainedAssignments();
        System.out.println(nFullyContainedAssignments);
        // Part 2
        findOverlappingPairs();
        System.out.println(nOverlappingPairs);

    }

    private static void findOverlappingPairs() {
        for (int i=0; i<inputList.size(); i++){
            String[] pair = inputList.get(i).split(",");
            checkOverlappingPair(pair);
        }
    }

    private static void findFullyContainedAssignments() {
        for (int i=0; i<inputList.size(); i++){
            String[] pair = inputList.get(i).split(",");
            checkFullyContainedAssignment(pair);
        }
    }

    private static void checkOverlappingPair(String[] pair) {
        int[] elf1 = getElfAssignment(pair[0]);
        int[] elf2 = getElfAssignment(pair[1]);
        if (!(elf1[1] < elf2[0] || elf2[1] < elf1[0])) {
            nOverlappingPairs++;
        }
    }

    private static void checkFullyContainedAssignment(String[] pair) {
        int[] elf1 = getElfAssignment(pair[0]);
        int[] elf2 = getElfAssignment(pair[1]);
        if ((elf1[0]<=elf2[0] && elf1[1]>=elf2[1]) || (elf1[0]>=elf2[0] && elf1[1]<=elf2[1])) {
            nFullyContainedAssignments++;
        }
    }

    private static int[] getElfAssignment(String elf) {
        String[] assignmentString = elf.split("-");
        int[] assignmentInt = {Integer.parseInt(assignmentString[0]), Integer.parseInt(assignmentString[1])};
        return assignmentInt;
    }
}
