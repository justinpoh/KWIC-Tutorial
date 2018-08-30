package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Pipe outputPipe;

    public Input(Pipe outputPipe){
        this.outputPipe = outputPipe;
    }

    public void readAllLines() {
        Scanner input = new Scanner(System.in);
        List<String> allLines = new ArrayList<String>();

        System.out.println("Please type in the line(s):");

        String currentLine = input.nextLine().trim();
        while(!currentLine.isEmpty()) {
            allLines.add(currentLine);
            currentLine = input.nextLine().trim();
        }

        outputPipe.sendData(allLines);
    }
}
