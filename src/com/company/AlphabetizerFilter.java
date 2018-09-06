package com.company;

import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

public class AlphabetizerFilter implements Runnable {

    private LinkedBlockingQueue<TreeSet<String>> outputPipe;
    private LinkedBlockingQueue<String> inputPipe;
    private TreeSet<String> sortedResult = new TreeSet<String>();

    public AlphabetizerFilter(LinkedBlockingQueue<String> inputPipe, LinkedBlockingQueue<TreeSet<String>> outputPipe){
        this.outputPipe = outputPipe;
        this.inputPipe = inputPipe;
    }

    private void sortLines() {
        try {
            sortedResult.add(inputPipe.take());
            outputPipe.put(new TreeSet<String>(sortedResult));

        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @Override
    public void run(){
        while(true){
            sortLines();
        }
    }
}
