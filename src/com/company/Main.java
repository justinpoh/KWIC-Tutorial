package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Pipes and Filter architecture

        //Initializing pipes and filters
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();

        Input inputFilter = new Input(pipe1);
        CircularShifter circularShifterFilter = new CircularShifter(pipe1, pipe2);
        Alphabetizer alphabetizerFilter = new Alphabetizer(pipe2, pipe3);
        Output outputFilter = new Output(pipe3);

        inputFilter.readAllLines();
        circularShifterFilter.circularShift();
        alphabetizerFilter.sortLines();
        outputFilter.printAllSortedLines();
    }
}
