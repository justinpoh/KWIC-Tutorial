package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kwic {

    public static void main(String[] args) {

        List<String> wordsToIgnore = new ArrayList<String>();

        //Initializing pipes and filters
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();

        Scanner input = new Scanner(System.in);

        // Getting the words to ignore
        System.out.println("Please enter the words to ignore:");
        String wordsToIgnoreInString = input.nextLine();
        wordsToIgnore = Arrays.asList(wordsToIgnoreInString.split("\\s+"));

        CircularShifterFilter circularShifterFilter = new CircularShifterFilter(pipe1, pipe2, wordsToIgnore);
        AlphabetizerFilter alphabetizerFilter = new AlphabetizerFilter(pipe2, pipe3);
        OutputFilter outputFilter = new OutputFilter(pipe3);


        System.out.println("Please type in the line(s):");


        while(input.hasNextLine()) {
            String currentLine = input.nextLine().trim();
            pipe1.sendData(currentLine);
            circularShifterFilter.circularShift();
            alphabetizerFilter.sortLines();
            outputFilter.printAllSortedLines();
        }

    }
}
