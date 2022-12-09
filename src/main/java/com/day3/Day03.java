package com.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.InputFetcher;

public class Day03 {
    private static int prioritySum;
    private static int groupPrioritySum;
    private static List<String> rucksackList;
    public static void main(String[] args) throws IOException {
        prioritySum = 0;
        groupPrioritySum = 0;
        String input =  InputFetcher.readTextFile("src/main/java/com/day3/input.txt");
        // Part 1
        sumOfPriorities(input);
        System.out.println(prioritySum);
        // Part 2
        rucksackList = new ArrayList<>();
        createRucksackList(input);
        sumOfGroupPriorities();
        System.out.println(groupPrioritySum);
    }

    private static void sumOfGroupPriorities() {
        for (int i=0; i<rucksackList.size(); i++) {
            if (i==0 || i%3==0) {
                String[] group = {
                    rucksackList.get(i),
                    rucksackList.get(i+1),
                    rucksackList.get(i+2)
                };
                String commonItem = commonGroupItem(group);
                int priority = getPriority(commonItem);
                groupPrioritySum += priority;
            }
        }
    }

    private static String commonGroupItem(String[] group) {
        for (int i = 0; i < group[0].length(); i++) {
            String currentItem = group[0].substring(i, i+1);
            if (group[1].contains(currentItem) && group[2].contains(currentItem)) {
                return currentItem;
            }
        }
        return null;
    }

    private static void createRucksackList(String input) {
        input.lines().forEach(
            rucksack -> {
                rucksackList.add(rucksack);
            }
        );
    }

    private static void sumOfPriorities(String input) {
        input.lines().forEach(
            rucksack -> {
                String [] compartments = splitCompartments(rucksack);
                String commonItem = findCommonItem(compartments);
                int priority = getPriority(commonItem);
                prioritySum += priority;
            }
        );
    }

    private static String[] splitCompartments(String rucksack) {
        final int mid = rucksack.length() / 2;
        String[] compartments = {rucksack.substring(0, mid), rucksack.substring(mid)};
        return compartments;
    }

    private static String findCommonItem(String[] compartments) {
        for (int i = 0; i < compartments[0].length(); i++) {
            String currentItem = compartments[0].substring(i, i+1);
            if (compartments[1].contains(currentItem)) {
                return currentItem;
            }
        }
        return null;
    }

    private static int getPriority(String item) {
        final String itemPriorities = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return itemPriorities.indexOf(item);
    }
    
}
