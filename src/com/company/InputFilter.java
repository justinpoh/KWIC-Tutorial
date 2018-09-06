package com.company;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class InputFilter implements Runnable {

    private LinkedBlockingQueue<String> outputPipe;
    Scanner input;

    public InputFilter(LinkedBlockingQueue outputPipe){
        this.outputPipe = outputPipe;
        input = Kwic.input;
    }

    private void read() {
        String currentLine = input.nextLine().trim();
        try {
            outputPipe.put(currentLine);
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @Override
    public void run(){
        while(input.hasNext()){
            read();
        }
        System.out.println("Program is terminating. Good bye.....");
        System.exit(0);

    }
}
