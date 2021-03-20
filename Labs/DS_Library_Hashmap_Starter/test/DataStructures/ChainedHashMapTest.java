/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Qiong
 */
public class ChainedHashMapTest {
    
    public ChainedHashMapTest() {
    }

    @Test
    public void testAdd() {
        ChainedHashMap<String, Integer>map = new ChainedHashMap<>(); 
        assertEquals(map.size(), 0);
        assertTrue(map.isEmpty());
        
        map.add("this", 1 ); 
        assertEquals(map.size(), 1);
        assertEquals(map.get("this").intValue(), 1);
        
        map.add("coder",2 ); 
        assertEquals(map.size(), 2);
        assertEquals(map.get("this").intValue(), 1);
        assertEquals(map.get("coder").intValue(), 2);
    }
    
    @Test
    public void testRemove() {
        ChainedHashMap<String, Integer>map = new ChainedHashMap<>(); 
        assertEquals(map.size(), 0);
        
        map.add("this",1 ); 
        map.add("coder",2 ); 
        map.add("this",4 ); 
        map.add("hi",5 ); 
        assertEquals(map.size(), 3);
        
        assertEquals(map.remove("this").intValue(), 4); 
        assertEquals(map.size(), 2);
        assertEquals(map.remove("this"), null); 
        assertEquals(map.size(), 2);
        assertFalse(map.isEmpty()); 
        
        assertEquals(map.remove("hi").intValue(), 5); 
        assertEquals(map.size(), 1);
    }
}