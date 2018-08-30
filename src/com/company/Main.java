package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Pipes and Filter architecture

        Input inputFilter = new Input();
        List<String> lines = inputFilter.readAllLines();

        CircularShifter circularShifterFilter = new CircularShifter();
        lines = circularShifterFilter.circularShift(lines);

        Alphabetizer alphabetizerFilter = new Alphabetizer();
        lines = alphabetizerFilter.getSortedLines(lines);

        Output outputFilter = new Output();
        outputFilter.printAllSortedLines(lines);
    }
}
