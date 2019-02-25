package com.productdictionary.service.impl;

import com.productdictionary.models.DictonaryEntry;
import com.productdictionary.service.ProductDictionary;

public class ProductDictionaryImpl implements ProductDictionary{
    
    private DictonaryEntry[] buckets;
    private static final int DEFAULT_SIZE = 16;
    
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
            while(existingDictonaryEntry.getNextEntry()!=null) {
                if(existingDictonaryEntry.getKey()==key) {
                    existingDictonaryEntry.setValue(value);
                    return;
                }
                existingDictonaryEntry = existingDictonaryEntry.getNextEntry();
            }
           if(existingDictonaryEntry.getKey()==key) {
               existingDictonaryEntry.setValue(value);
           } else {
               existingDictonaryEntry.setNextEntry(dictonaryEntry);
           }
        }
    }

    @Override
    public String get(int key) {
        int bucketIndex = getHashCode(key)%buckets.length;
        DictonaryEntry dictonaryEntry = buckets[bucketIndex];
        while(dictonaryEntry!=null) {
            if(dictonaryEntry.getKey()==key) {
                return dictonaryEntry.getValue();
            }
            dictonaryEntry = dictonaryEntry.getNextEntry();
        }
        return null;
    }
    
    public int getHashCode(int key) {
        return Integer.valueOf(key).hashCode();
    }
    
    public static void main(String[] args) {
        ProductDictionary dictionary = new ProductDictionaryImpl();
        dictionary.set(1, "Sony TV");
        dictionary.set(2, "Apple iphone");
        dictionary.set(17, "Sony TV Bravia");
        System.out.println(dictionary.get(17));
    }
}
