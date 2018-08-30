package com.company;

import java.util.ArrayList;
import java.util.List;

public class Output {
    public void printAllSortedLines(List<String> sortedLines) {

        System.out.println("These are the shifted and sorted lines:");

        for (String line : sortedLines) {
            System.out.println(line);
        }

        System.out.println("End of program. Good bye!");
    }
}
