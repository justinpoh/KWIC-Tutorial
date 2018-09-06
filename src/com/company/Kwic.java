package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Kwic {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {


        //Initializing pipes and filters
        LinkedBlockingQueue<String> pipe1 = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<String> pipe2 = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<TreeSet<String>> pipe3 = new LinkedBlockingQueue<>();

        // Getting the words to ignore
        System.out.println("Please enter the words to ignore:");
        String wordsToIgnoreInString = input.nextLine();
        List<String> wordsToIgnore = Arrays.asList(wordsToIgnoreInString.split("\\s+"));

        // Initializing the filters
        InputFilter inputFilter = new InputFilter(pipe1);
        CircularShifterFilter circularShifterFilter = new CircularShifterFilter(pipe1, pipe2, wordsToIgnore);
        AlphabetizerFilter alphabetizerFilter = new AlphabetizerFilter(pipe2, pipe3);
        OutputFilter outputFilter = new OutputFilter(pipe3);

        System.out.println("Please type in the line(s):");

        //Start the filters
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(inputFilter);
        executorService.execute(circularShifterFilter);
        executorService.execute(alphabetizerFilter);
        executorService.execute(outputFilter);


    }
}
