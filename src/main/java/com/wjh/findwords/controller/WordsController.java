package com.wjh.findwords.controller;

import com.alibaba.fastjson.JSONObject;
import com.wjh.findwords.entity.Dictionary;
import com.wjh.findwords.service.AddWords;
import com.wjh.findwords.service.FindWords;
import com.wjh.findwords.service.InitDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Control the page links.
 * @author：Candy
 * @date: 2020/2/22
 */

@Controller
public class WordsController {

    private static Logger logger = LoggerFactory.getLogger(WordsController.class);

    @Autowired
    private InitDictionary initDictionary;

    @Autowired
    private Dictionary dictionary;

    @Autowired
    private AddWords addWords;

    @Autowired
    private FindWords findWords;

    @RequestMapping(value = "/homepage")
    public String homePage() {
        //Initial the default dictionary and both dictionaries.
        initDictionary.initDefault(dictionary);
        initDictionary.initBoth(dictionary);
        //Suppose the user provided the following customized dictionary.
        addWords.addWords("i,like,sam,sung,mobile,icecream,man go,mango", dictionary);
        return "homepage";
    }

    /**
     * Add words to the dictionary.
     *
     * @param words The user
     * @return Add success.
     */
    @ResponseBody
    @RequestMapping(value = "/addwords", method = RequestMethod.POST)
    public JSONObject addWords(String words) {
        String result = addWords.addWords(words, dictionary);
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("msg", result);
        return resultJSON;
    }


    /**
     * Find words in the dictionary.
     *
     * @param letters The user inputted the serial letter which need to be split.
     * @param dicType The type of dictionary.It decides which dictionary to find words in.
     * @return Output all sentence.
     */
    @ResponseBody
    @RequestMapping(value = "/findwords", method = RequestMethod.GET)
    public String findWords(String letters, String dicType) {
        List resultList = new ArrayList();
        if (dicType.equals("defaultDic")) {
            logger.info("defaultDictionary==" + dictionary.getDefaultDictionary());
            resultList = findWords.splitWords(letters, dictionary.getDefaultDictionary());
        }
        if (dicType.equals("userDic")) {
            logger.info("userDictionary==" + dictionary.getUserDictionary());
            resultList = findWords.splitWords(letters, dictionary.getUserDictionary());
        }
        if (dicType.equals("bothDic")) {
            logger.info("bothDictionary==" + dictionary.getBothDictionaries());
            resultList = findWords.splitWords(letters, dictionary.getBothDictionaries());
        }
        String result = "";
        for (int i = 0; i < resultList.size(); i++) {
            result += resultList.get(i).toString() + "\r\n";
        }
        logger.info("Output result==" + result);
        return result;
    }
}
