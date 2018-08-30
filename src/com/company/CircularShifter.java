package com.company;

import java.util.ArrayList;
import java.util.List;

public class CircularShifter {


    public List<String> circularShift(List<String> allLines) {

        List<String> resultArray = new ArrayList<String>();

        for (String line: allLines) {
            String[] words = getWordsFromLine(line);
            for(int i = 0; i < words.length; i++) {
                words = shiftLeft(words);
                String sentence = String.join(" ", words);

                //Check for fullstop not at end
                while (sentence.contains(".") && sentence.indexOf(".") != sentence.length() - 1) {
                    sentence = sentence.replace(".", "");
                }

                //Remove comma if at end
                while (sentence.contains(",") && sentence.indexOf(",") == sentence.length() - 1) {
                    sentence = sentence.replace(",", "");
                }

                resultArray.add(sentence);
            }
        }

        return resultArray;

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
        }
        return shiftedWords;
    }
}
