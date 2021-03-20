/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Qiong
 */
public class LinkedStackTest {
    
    public LinkedStackTest() {
    }

    /**
     * Test of pop method, of class LinkedStackOld.
     */
    @Test
    public void testPop() throws Exception {
        LinkedStack<String> instance = new LinkedStack<>();
        assertTrue(instance.size() == 0);
        
        // test the pop method (popping off an element from the empty stack)
        try{
            instance.pop();
            fail("should not get here");
        } catch (EmptyCollectionException ex){
            System.out.println("Expected to get an exception");
            assertTrue("caught exception", true);
        } catch (Exception ex){
            assertFalse(true);
            fail("should not get here");
        }
        
        String name1 = new String("Ellen");
        instance.push(name1);
        String name2 = new String("Wei");
        instance.push(name2);
        assertTrue(instance.size() == 2);
        
        try{
            String another = instance.pop();
            assertTrue(instance.size() == 1);
            assertTrue(name2.equals(another));
            
            instance.pop();
            assertTrue(instance.isEmpty());
        } catch (Exception ex){
            assertFalse(true);
        }
    }

    /**
     * Test of push method, of class LinkedStackOld.
     */
    @Test
    public void testPush() {
        LinkedStack<String> instance = new LinkedStack<>();
        assertTrue(instance.size() == 0);
        assertTrue(instance.isEmpty());
        
        String name = "Ellen";
        instance.push(name);
        assertTrue(instance.size() == 1);
        try{
            assertTrue(name.equals(instance.peek()));
        } catch (Exception ex) {
            fail("Not expected exception");
        }
    }

    /**
     * Test of peek method, of class LinkedStackOld.
     */
    @Test
    public void testPeek() throws Exception {
        LinkedStack instance = new LinkedStack();
        
        try {
            instance.peek();
            fail("Should not get here");
        } catch (EmptyCollectionException ex){
            assertTrue(true);
        } catch (Exception ex) {
            fail("Not expected exception");
        }
        
        String name = "Ellen";
        instance.push(name);
        assertTrue(instance.size() == 1);
        try{
            assertTrue(name.equals(instance.peek()));
        } catch (Exception ex) {
            fail("Not expected exception");
        }
    }

    /**
     * Test of isEmpty method, of class LinkedStackOld.
     */
    @Test
    public void testIsEmpty() {
        LinkedStack instance = new LinkedStack();
        
    }

    /**
     * Test of size method, of class LinkedStackOld.
     */
    @Test
    public void testSize() {
        LinkedStack instance = new LinkedStack();
        assertTrue(instance.size() == 0);
        
        String name = "Ellen";
        instance.push(name);
        assertTrue(instance.size() == 1);
    }

    /**
     * Test of toString method, of class LinkedStackOld.
     */
    @Test
    public void testToString() {
        LinkedStack instance = new LinkedStack();
        String name = "Ellen";
        instance.push(name);
        String text = "LinkedListStack{count=1, top=" + name + '}';
        System.out.println(instance.toString());
        assertTrue(text.equals(instance.toString()));
    }
}
