package com.wjh.findwords;

import com.wjh.findwords.entity.Dictionary;
import com.wjh.findwords.service.AddWords;
import com.wjh.findwords.service.FindWords;
import com.wjh.findwords.service.InitDictionary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: Test unit.
 * @author：Candy
 * @date: 2020/2/22
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWords {

    @Autowired
    private AddWords addWords;

    @Autowired
    private Dictionary dictionary;

    @Autowired
    private InitDictionary initDictionary;

    @Autowired
    private FindWords findWords;

    @Test
    public void testAddWords(){
        initDictionary.initDefault(dictionary);
        initDictionary.initBoth(dictionary);
        String words = "orange,pear";
        addWords.addWords(words,dictionary);
    }

    @Test
    public void testFindWords(){
        initDictionary.initDefault(dictionary);
        initDictionary.initBoth(dictionary);
        String letters="ilovesamsungmobile";
        findWords.splitWords(letters,dictionary.getBothDictionaries());
    }




}