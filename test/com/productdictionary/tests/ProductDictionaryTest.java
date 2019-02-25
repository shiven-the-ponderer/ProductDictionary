package com.productdictionary.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.productdictionary.service.ProductDictionary;
import com.productdictionary.service.impl.ProductDictionaryImpl;

public class ProductDictionaryTest {
    
    @Test
    public void testDictionaryGetValueSuccess() {
        ProductDictionary dictionary = new ProductDictionaryImpl();
        dictionary.set(1, "Sony TV");
        dictionary.set(2, "Apple iphone");
        dictionary.set(1, "Sony TV Bravia");
        assertNotNull(dictionary.get(1));
        assertEquals("Sony TV Bravia", dictionary.get(1));
    }
    
    @Test
    public void testDictionaryGetValueNull() {
        ProductDictionary dictionary = new ProductDictionaryImpl();
        dictionary.set(1, "Sony TV");
        dictionary.set(2, "Apple iphone");
        dictionary.set(1, "Sony TV Bravia");
        assertNull(dictionary.get(3));
        assertEquals(null, dictionary.get(3));
    }
    
    @Test
    public void testDictionaryGetCollisionBucketIndexValue() {
        ProductDictionary dictionary = new ProductDictionaryImpl();
        dictionary.set(1, "Sony TV");
        dictionary.set(2, "Apple iphone");
        dictionary.set(17, "Sony TV Bravia");
        assertNotNull(dictionary.get(17));
        assertEquals("Sony TV Bravia", dictionary.get(17));
        assertEquals("Sony TV", dictionary.get(1));

    }

}
