package com.wjh.findwords.service;

import com.wjh.findwords.entity.Dictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddWords {
    private Logger logger = LoggerFactory.getLogger(AddWords.class);

    /**
     * @param words      The user provided the words to the dictionary as additional input.
     * @param dictionary It is used to store the contents of dictionary.
     * @return
     */
    public String addWords(String words, Dictionary dictionary) {
        if (!words.substring(words.length() - 1).matches("[a-zA-Z]+")) {
            words = words.substring(0, words.length() - 1);
        }
        words = words.replace("\n", ",").replace("\r", ",").trim();
        String[] wordsArr = words.split(",");
        List userList = new ArrayList();
        if (dictionary.getUserDictionary() != null) {
            userList = dictionary.getUserDictionary();
        }
        List bothList = dictionary.getBothDictionaries();
        for (int i = 0; i < wordsArr.length; i++) {
            boolean addWord = true;
            //Add words to user customized dictionary.
            if (userList != null) {
                for (int j = 0; j < userList.size(); j++) {
                    if (wordsArr[i].equals(userList.get(j).toString())) {
                        addWord = false;
                        break;
                    }
                }
                if (wordsArr[i] != null && !"".equals(wordsArr[i])) {
                    if (addWord) {
                        userList.add(wordsArr[i]);
                    }
                }
            } else {
                userList.add(wordsArr[i]);
            }
            //Add words to both dictionaries.
            for (int j = 0; j < bothList.size(); j++) {
                if (wordsArr[i].equals(bothList.get(j).toString())) {
                    addWord = false;
                    break;
                }
            }
            if (wordsArr[i] != null && !"".equals(wordsArr[i])) {
                if (addWord) {
                    bothList.add(wordsArr[i]);
                }
            }
        }

        dictionary.setUserDictionary(userList);
        dictionary.setBothDictionaries(bothList);
        logger.info("function==addWords;defaultDictionary==" + dictionary.getDefaultDictionary());
        logger.info("function==addWords;userDictionary==" + dictionary.getUserDictionary());
        logger.info("function==addWords;bothDictionaries==" + dictionary.getBothDictionaries());
        String result = "Add success!";
        return result;
    }
}
