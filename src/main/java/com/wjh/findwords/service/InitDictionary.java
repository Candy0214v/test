package com.wjh.findwords.service;

import com.wjh.findwords.entity.Dictionary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Initialize the default dictionary.
 * @author：Candy
 * @date: 2020/2/22
 */

@Service
public class InitDictionary {
    public void initDefault(Dictionary dictionary) {
        List dictionaryList = new ArrayList();
        dictionaryList.add("i");
        dictionaryList.add("like");
        dictionaryList.add("sam");
        dictionaryList.add("sung");
        dictionaryList.add("samsung");
        dictionaryList.add("mobile");
        dictionaryList.add("ice");
        dictionaryList.add("cream");
        dictionaryList.add("man go");
        dictionary.setDefaultDictionary(dictionaryList);

    }
    public void initBoth(Dictionary dictionary) {
        List dictionaryList = new ArrayList();
        dictionaryList.add("i");
        dictionaryList.add("like");
        dictionaryList.add("sam");
        dictionaryList.add("sung");
        dictionaryList.add("samsung");
        dictionaryList.add("mobile");
        dictionaryList.add("ice");
        dictionaryList.add("cream");
        dictionaryList.add("man go");
        dictionary.setBothDictionaries(dictionaryList);
    }
}
