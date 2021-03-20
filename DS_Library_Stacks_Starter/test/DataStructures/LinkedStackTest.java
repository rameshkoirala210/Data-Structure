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
 * @author ITSC 2214 Q
 */
public class LinkedStackTest {
    
    public LinkedStackTest() {
    }

    /**
     * Test of pop method, of class LinkedStack
     * @throws Exception 
     */
    @Test(expected=EmptyCollectionException.class)
    public void testPop1() throws Exception {
        LinkedStack<String> instance = new LinkedStack<>();
        instance.pop();
    }
    
    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop2() throws Exception {
        LinkedStack<String> instance = new LinkedStack<>();
        assertTrue(instance.size() == 0);
        
        String name1 = new String("Ellen");
        instance.push(name1);
        String name2 = new String("Wei");
        instance.push(name2);
        assertEquals(instance.size(), 2);
        
        try{
            String another = instance.pop();
            assertEquals(instance.size(), 1);
            assertTrue(name2.equals(another));
            
            instance.pop();
            assertTrue(instance.isEmpty());
        } catch (Exception ex){
            assertFalse(true);
        }
    }

    /**
     * Test of push method, of class LinkedStack.
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
     * Test of peek method, of class LinkedStack.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testPeek1() throws Exception {
        LinkedStack<String> instance = new LinkedStack<>();
        instance.peek();
    }
    
    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test
    public void testPeek2() throws Exception {
        LinkedStack<String> instance = new LinkedStack<>();
       assertTrue(instance.size() == 0);

       String name1 = new String("Ellen");
       instance.push(name1);
       String name2 = new String("Wei");
       instance.push(name2);
       assertEquals(instance.size(), 2);

       try{
             String another = instance.peek();
             assertEquals(instance.size(), 2);
             assertTrue(name2.equals(another));
             
             String name3 = new String("asda");
             instance.push(name3);
           
             assertEquals(instance.size(), 3);
             assertTrue(name3.equals(instance.peek()));
             
       } catch (Exception ex){
             assertFalse(true);
       }

    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty() {
        LinkedStack instance = new LinkedStack();
        assertTrue(instance.isEmpty());
        String name = "Ellen";
        instance.push(name);
        assertFalse(instance.isEmpty());
    }

    /**
     * Test of size method, of class LinkedStack.
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
     * Test of toString method, of class LinkedStack.
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
