package com.company;

import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

public class OutputFilter implements Runnable {

    private LinkedBlockingQueue<TreeSet<String>> inputPipe;

    public OutputFilter(LinkedBlockingQueue<TreeSet<String>>  inputPipe){
        this.inputPipe = inputPipe;
    }

    private void printAllSortedLines() {


        try {
            TreeSet<String> sortedLines = inputPipe.take();
            System.out.println("[Result]:");
            System.out.println();
            sortedLines.forEach(System.out::println);
            System.out.println();
            System.out.println("Please type in the next line (Press Ctrl+D to end the program):");
            System.out.println();
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @Override
    public void run(){
        while(true){
            printAllSortedLines();
        }
    }
}
