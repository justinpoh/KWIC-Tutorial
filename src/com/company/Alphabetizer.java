package com.company;

import java.util.Collections;
import java.util.List;

public class Alphabetizer {

    private Pipe outputPipe;
    private Pipe inputPipe;

    public Alphabetizer(Pipe inputPipe, Pipe outputPipe){
        this.outputPipe = outputPipe;
        this.inputPipe = inputPipe;
    }

    public void sortLines() {
        List<String> linesToSort = inputPipe.getData();
        Collections.sort(linesToSort);
        outputPipe.sendData(linesToSort);
    }
}
