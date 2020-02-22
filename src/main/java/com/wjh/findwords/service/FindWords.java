package com.wjh.findwords.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: According to the user's choice, finds words in the user customized dictionary or in the both dictionaries.
 * @author：Candy
 * @date: 2020/2/22
 */

@Service
public class FindWords {

    private Logger logger = LoggerFactory.getLogger(FindWords.class);

    /**
     * @param letters    The user inputted the serial letters which need to be split.
     * @param dictionary Find the words in the dictionary.
     * @return Sentences after word division.
     */
    public List splitWords(String letters, List dictionary) {
        List dictionaryList = dictionary;
        String firstLetter = letters.substring(0,1);
        if(firstLetter.equals("i")||firstLetter.equals("I")){
            letters = letters.substring(0,1)+" "+letters.substring(1);
        }
        for (int i = 0; i < dictionaryList.size(); i++) {
            if(!(dictionaryList.get(i).toString().equals("i")||dictionaryList.get(i).toString().equals("I"))){
                String word = dictionaryList.get(i).toString();
                int index = 0;
                if (word.contains(" ")) {
                    String[] words = word.split(" ");
                    for (int j = 0; j < words.length; j++) {
                        index = letters.indexOf(words[j]);
                        int letterLength = letters.length();
                        for (int k = index; k < letterLength; k++) {
                            if (index >= 0) {
                                letters = letters.substring(0, index) + " " + letters.substring(index, index + words[j].length()) + " " + letters.substring(index + words[j].length());
                                index = letters.indexOf(words[j], index + words[j].length());
                            }
                        }

                    }
                } else {
                    index = letters.indexOf(word);
                    int letterLength = letters.length();
                    for (int k = index; k < letterLength; k++) {
                        if (index >= 0) {
                            letters = letters.substring(0, index) + " " + letters.substring(index, index + word.length()) + " " + letters.substring(index + word.length());
                            index = letters.indexOf(word, index + word.length());
                        }
                    }
                }
            }

        }
        letters = letters.trim().replaceAll("\\s+", " ");
        logger.info("function==splitWords. preliminary result==" + letters);

        List resultList = new ArrayList();
        resultList.add(letters);
        List checkSerialWord = checkSerialWords(letters, dictionary);
        if (checkSerialWord != null) {
            for (int i = 0; i < checkSerialWord.size(); i++) {
                resultList.add(checkSerialWord.get(i));
            }
        }
        return resultList;
    }

    /**
     * @param sentence   Preliminary search result.
     * @param dictionary Find the other words in the dictionary
     * @return The other results.
     */
    public List checkSerialWords(String sentence, List dictionary) {
        List dictionaryList = dictionary;
        String[] words = sentence.split(" ");
        List sentenceList = new ArrayList();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < dictionaryList.size(); j++) {
                if ((words[i] + words[i + 1]).equals(dictionaryList.get(j).toString())) {
                    String mergedSentence = sentence.replace(words[i] + " " + words[i + 1], dictionaryList.get(j).toString());
                    sentenceList.add(mergedSentence);
                    break;
                }
            }
        }
        logger.info("function==checkSerialWords;The other results==" + sentenceList.toString());
        return sentenceList;
    }


    /**
     * Test this function.
     *
     * @param args
     */
    public static void main(String[] args) {
        List dictionaryList = new ArrayList();
        dictionaryList.add("like");
        dictionaryList.add("i");
        dictionaryList.add("sam");
        dictionaryList.add("sung");
        dictionaryList.add("samsung");
        dictionaryList.add("mobile");
        dictionaryList.add("ice");
        dictionaryList.add("cream");
        dictionaryList.add("man go");
        dictionaryList.add("me");
        dictionaryList.add("men");

        String letters = "Iiapplelikemeandmen";
        FindWords splitWords = new FindWords();
        System.out.println(splitWords.splitWords(letters, dictionaryList));
    }
}
