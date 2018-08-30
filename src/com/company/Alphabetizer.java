package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabetizer {

    private List<String> shiftedLines;

    public Alphabetizer(List<String> shiftedLinesInput) {
        shiftedLines = new ArrayList<String>(shiftedLinesInput);
    }

    public List<String> getSortedLines() {
        Collections.sort(shiftedLines);
        return shiftedLines;
    }
}
