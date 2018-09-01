package com.company;

import java.util.ArrayList;
import java.util.List;

public class CircularShifter {

    private Pipe outputPipe;
    private Pipe inputPipe;

    public CircularShifter(Pipe inputPipe, Pipe outputPipe){
        this.outputPipe = outputPipe;
        this.inputPipe = inputPipe;
    }

    public void circularShift() {

        List<String> allLines = inputPipe.getData();
        List<String> resultArray = new ArrayList<String>();

        for (String line: allLines) {
            String[] words = getWordsFromLine(line);
            for(int i = 0; i < words.length; i++) {
                words = shiftLeft(words);
                String sentence = String.join(" ", words);

                //Check for fullstop not at end
                while (sentence.contains(".") && (sentence.indexOf(".") != sentence.length() - 1)) {
                    //Regex syntax
                    sentence = sentence.replaceFirst("\\.", "");
                }

                //Remove comma if at end
                while (sentence.contains(",") && (sentence.lastIndexOf(",") == sentence.length() - 1)) {
                    sentence = sentence.substring(0, sentence.lastIndexOf(","));
                }

                resultArray.add(sentence);
            }
        }

        outputPipe.sendData(resultArray);
    }

    private String[] getWordsFromLine(String line) {
        return line.split("\\s+");
    }

    private String[] shiftLeft(String[] words) {

        String[] shiftedWords = new String[words.length]; //Temp array
        if (words.length > 1) {
            //Copy (2nd word onwards) to shiftedWords then copy first word to the last index of shiftedWords
            System.arraycopy(words, 1, shiftedWords, 0, words.length - 1);
            System.arraycopy(words, 0, shiftedWords, shiftedWords.length - 1, 1);
        } else {
            return words;
        }
        return shiftedWords;
    }

}
