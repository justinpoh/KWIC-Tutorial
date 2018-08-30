package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public List<String> readAllLines() {
        Scanner input = new Scanner(System.in);
        List<String> allLines = new ArrayList<String>();
        String currentLine = input.nextLine().trim();

        while(!currentLine.isEmpty()) {
            allLines.add(currentLine);
            currentLine = input.nextLine().trim();
        }

        return allLines;
    }
}
