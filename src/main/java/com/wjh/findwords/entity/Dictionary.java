package com.wjh.findwords.entity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: POJO
 * @author：Candy
 * @date: 2020/2/22
 */

@Service
public class Dictionary {

    private List defaultDictionary;

    private List userDictionary;

    private List bothDictionaries;

    /*public void initDefaultDictionary(){
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
        setDefaultDictionary(dictionaryList);
    }*/

    public List getDefaultDictionary() {
        return defaultDictionary;
    }

    public void setDefaultDictionary(List defaultDictionary) {
        this.defaultDictionary = defaultDictionary;
    }

    public List getUserDictionary() {
        return userDictionary;
    }

    public void setUserDictionary(List userDictionary) {
        this.userDictionary = userDictionary;
    }

    public List getBothDictionaries() {
        return bothDictionaries;
    }

    public void setBothDictionaries(List bothDictionaries) {
        this.bothDictionaries = bothDictionaries;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "defaultDictionary=" + defaultDictionary +
                ", userDictionary=" + userDictionary +
                ", bothDictionaries=" + bothDictionaries +
                '}';
    }
}
