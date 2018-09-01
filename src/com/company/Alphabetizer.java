package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabetizer {

    private Pipe outputPipe;
    private Pipe inputPipe;

    private List<String> allSortedResult;

    public Alphabetizer(Pipe inputPipe, Pipe outputPipe){
        this.outputPipe = outputPipe;
        this.inputPipe = inputPipe;
        allSortedResult = new ArrayList<>();
    }

    public void sortLines() {
        allSortedResult.addAll(inputPipe.getData());
        Collections.sort(allSortedResult);
        outputPipe.sendData(allSortedResult);
    }
}
