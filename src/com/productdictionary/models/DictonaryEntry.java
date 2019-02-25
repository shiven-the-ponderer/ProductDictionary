package com.productdictionary.models;

public class DictonaryEntry {
    
    int key;
    String value;
    DictonaryEntry nextEntry;
    
    public DictonaryEntry(int key, String value) {
        this.key = key;
        this.value = value;
        this.nextEntry = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DictonaryEntry getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(DictonaryEntry nextEntry) {
        this.nextEntry = nextEntry;
    }
    
    

}
