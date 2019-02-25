package com.productdictionary.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.productdictionary.models.DictonaryEntry;
import com.productdictionary.service.ProductDictionary;

public class ProductDictionaryImpl implements ProductDictionary{
    
    private DictonaryEntry[] buckets;
    private static final int DEFAULT_SIZE = 16;
    private int size = 0;
    
    Map<String,Integer> map = new HashMap<>();
    
    
    
    public ProductDictionaryImpl() {
        buckets = new DictonaryEntry[DEFAULT_SIZE];
    }
    
    public ProductDictionaryImpl(int size) {
        buckets = new DictonaryEntry[size];
    }
    
    @Override
    public void set(int key, String value) {
        DictonaryEntry dictonaryEntry = new DictonaryEntry(key, value);
        int bucketIndex = getHashCode(key)%buckets.length;
        DictonaryEntry existingDictonaryEntry = buckets[bucketIndex];
        if(existingDictonaryEntry==null) {
            buckets[bucketIndex] = dictonaryEntry;
        } else {
            while(existingDictonaryEntry!=null) {
                if(existingDictonaryEntry.getKey()==key) {
                    existingDictonaryEntry.setValue(value);
                }
                existingDictonaryEntry = existingDictonaryEntry.getNextEntry();
            }
        }
    }

    @Override
    public String get(int key) {
        return null;
    }
    
    public int getHashCode(int key) {
        return Integer.valueOf(key).hashCode();
    }
    
}
