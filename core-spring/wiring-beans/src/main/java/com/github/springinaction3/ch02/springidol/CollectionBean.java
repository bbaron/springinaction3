package com.github.springinaction3.ch02.springidol;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBean {

    private List<String> listOfStrings;
    private Set<String> setOfStrings;
    private String[] arrayOfStrings;
    private Map<String, Integer> stringsMappedToIntegers;

    public List<String> getListOfStrings() {
        return listOfStrings;
    }

    public void setListOfStrings(List<String> listOfStrings) {
        this.listOfStrings = listOfStrings;
    }

    public Set<String> getSetOfStrings() {
        return setOfStrings;
    }

    public void setSetOfStrings(Set<String> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }

    public String[] getArrayOfStrings() {
        return arrayOfStrings;
    }

    public void setArrayOfStrings(String[] arrayOfStrings) {
        this.arrayOfStrings = arrayOfStrings;
    }

    public Map<String, Integer> getStringsMappedToIntegers() {
        return stringsMappedToIntegers;
    }

    public void setStringsMappedToIntegers(Map<String, Integer> stringsMappedToIntegers) {
        this.stringsMappedToIntegers = stringsMappedToIntegers;
    }

}
