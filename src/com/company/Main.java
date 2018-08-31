package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Initializing pipes and filters
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();

        CircularShifter circularShifterFilter = new CircularShifter(pipe1, pipe2);
        Alphabetizer alphabetizerFilter = new Alphabetizer(pipe2, pipe3);
        Output outputFilter = new Output(pipe3);

        Scanner input = new Scanner(System.in);

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
