package com.day5;

import com.InputFetcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 {
    private static List<List<Character>> listOfStacks;
    private static int nMoves;
    private static int fromStack;
    private static int toStack;
    private static int part;
    public static void main(String[] args) throws IOException {
        part = 2;
        initializeStacks();
        List<String> input = InputFetcher.getInputList("src/main/java/com/day5/input.txt");
        executeInput(input);
        printTopOfStacks();
    }

    private static void printTopOfStacks(){
        for (int i=1; i<listOfStacks.size(); i++){
            int lastItemIndex = listOfStacks.get(i).size() - 1;
            System.out.println(listOfStacks.get(i).get(lastItemIndex));
        }
    }

    private static void executeInput(List<String> input){
        for (int i=0; i<input.size(); i++){
            parseCommand(input.get(i));
            if (part == 1){
                executeCommandCrateMover9000();
            } else {
                executeCommandCrateMover9001();
            }
        }
    }

    private static void executeCommandCrateMover9001(){
        int fromIndex = listOfStacks.get(fromStack).size() - nMoves;
        for (int i=0; i<nMoves; i++){
            listOfStacks.get(toStack).add(listOfStacks.get(fromStack).remove(fromIndex));
        }
    }

    private static void executeCommandCrateMover9000(){
        for (int i=0; i<nMoves; i++){
            int fromIndex = listOfStacks.get(fromStack).size() - 1;
            listOfStacks.get(toStack).add(listOfStacks.get(fromStack).remove(fromIndex));
        }
    }

    private static void parseCommand(String command){
        List<String> words = Arrays.asList(command.split(" "));
        nMoves = Integer.parseInt(words.get(1));
        fromStack = Integer.parseInt(words.get(3));
        toStack = Integer.parseInt(words.get(5));
    }

    private static void initializeStacks() {
        List<Character> stack1 = new ArrayList<Character>() {
            {
                add('F');
                add('H');
                add('B');
                add('V');
                add('R');
                add('Q');
                add('D');
                add('P');
            }
        };
        List<Character> stack2 = new ArrayList<Character>(){
            {
                add('L');
                add('D');
                add('Z');
                add('Q');
                add('W');
                add('V');
            }
        };
        List<Character> stack3 = new ArrayList<Character>(){
            {
                add('H');
                add('L');
                add('Z');
                add('Q');
                add('G');
                add('R');
                add('P');
                add('C');
            }
        };
        List<Character> stack4 = new ArrayList<Character>(){
            {
                add('R');
                add('D');
                add('H');
                add('F');
                add('J');
                add('V');
                add('B');
            }
        };
        List<Character> stack5 = new ArrayList<Character>(){
            {
                add('Z');
                add('W');
                add('L');
                add('C');
            }
        };
        List<Character> stack6 = new ArrayList<Character>(){
            {
                add('J');
                add('R');
                add('P');
                add('N');
                add('T');
                add('G');
                add('V');
                add('M');
            }
        };
        List<Character> stack7 = new ArrayList<Character>(){
            {
                add('J');
                add('R');
                add('L');
                add('V');
                add('M');
                add('B');
                add('S');
            }
        };
        List<Character> stack8 = new ArrayList<Character>(){
            {
                add('D');
                add('P');
                add('J');
            }
        };
        List<Character> stack9 = new ArrayList<Character>(){
            {
                add('D');
                add('C');
                add('N');
                add('W');
                add('V');
            }
        };
        listOfStacks = new ArrayList<List<Character>>();
        listOfStacks.add(new ArrayList<Character>());   // Dummystack to match list index to stack number i.e. index 1 == stack 1
        listOfStacks.add(stack1);
        listOfStacks.add(stack2);
        listOfStacks.add(stack3);
        listOfStacks.add(stack4);
        listOfStacks.add(stack5);
        listOfStacks.add(stack6);
        listOfStacks.add(stack7);
        listOfStacks.add(stack8);
        listOfStacks.add(stack9);
    }
}
