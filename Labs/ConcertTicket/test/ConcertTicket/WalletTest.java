/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcertTicket;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manuel Perez-quinones
 * @version Fall 2019
 */
public class WalletTest {
     /**
     * Constructor
     */
    public WalletTest() {
        // The class is only for test usage
    }

    /**
     * Test of add method, of class Wallet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ConcertTicket ct1 = new ConcertTicket("Peter", new Date("08/17/2019"), 18.5);
        ConcertTicket ct2 = new ConcertTicket("Brandon", new Date("08/17/1019"), 28.5);
        
        // Check the comparison method of the ConcertTicket class
        assertEquals(ct1.compareTo(ct2), -1);
        assertEquals(ct2.compareTo(ct1), 1);
        
        Wallet instance = new Wallet();
        
        // check adding a node when the Wallet is empty
        assertEquals(0, instance.getSize());
        instance.add(ct1);
        assertEquals(1, instance.getSize());
        
        // check adding a node when the Wallet is not empty
        instance.add(ct2);
        assertEquals(2, instance.getSize());
        assertEquals(instance.tickets[1].compareTo(ct2), 0);
        
        // Check adding a ticket when the wallet is full
        for (int i = instance.getSize(); i < instance.getLength(); i++) {
            instance.add(new  ConcertTicket("Test", new Date("09/17/2019"), 38.5));
        }
        instance.add(new  ConcertTicket("Test", new Date("09/17/2019"), 38.5));
        assertEquals(instance.getLength(), 20);
    }

    /**
     * Test of remove method, of class Wallet.
     */
    @Test
    public void testRemove() {
        
        ConcertTicket ct1 = new ConcertTicket("Peter", new Date("08/17/2019"), 18.5);
        ConcertTicket ct2 = new ConcertTicket("Brandon", new Date("08/17/1019"), 28.5);
        
        Wallet instance = new Wallet();
        
        // Check removing a concert ticket from an empty wallet
        ConcertTicket ctIsNull = instance.remove();
        assertSame(ctIsNull, null);
        
        // Add concert tickets
        System.out.println("add");
        instance.add(ct1);
        System.out.println("add");
        instance.add(ct2);
 
        System.out.println("remove");
        // Check removing a concert ticket from a non-empty wallet
        instance.remove();
        ConcertTicket ct1Removed = instance.remove();
        
        System.out.println(instance.getSize());
        assertEquals(0, instance.getSize());
        
        System.out.println(ct1.getPrice());
        System.out.println(ct1Removed.getPrice());
        assertEquals(ct1.compareTo(ct1Removed), 0);
    }
    
    
    
    /**
     * Test of resize method, of class Wallet.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        
        // Check default constructor
        ConcertTicket ct = new ConcertTicket();
        assertSame((int)(ct.getPrice()), 0);
             
        ConcertTicket ct1 = new ConcertTicket("Peter", new Date("08/17/2019"), 18.5);
        ConcertTicket ct2 = new ConcertTicket("Brandon", new Date("08/17/1019"), 28.5);
        
        // add concert tickets
        Wallet instance = new Wallet();
        int oriLength = instance.getLength();
        System.out.println("add");
        instance.add(ct1);
        System.out.println("add");
        instance.add(ct2);
        
        // check the resize function
        instance.resize();
        assertEquals(oriLength * 2, instance.getLength());    
    }

    /**
     * Test of toString method, of class Wallet.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        // Construct a non-empty wallet
        ConcertTicket ct1 = new ConcertTicket("Peter", new Date("08/17/2019"), 18.5);
        ConcertTicket ct2 = new ConcertTicket("Brandon", new Date("08/17/1019"), 28.5);
        Wallet instance = new Wallet();
        System.out.println("add");
        instance.add(ct1);
        System.out.println("add");
        instance.add(ct2);
        
        // Check the toString function
        assertNotSame(instance.toString().length(), 0);
    }

    /**
     * Test of getSize method, of class Wallet.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Wallet instance = new Wallet();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        instance.add(new ConcertTicket("Titanic", new Date("08/17/2019"), 18.5));
        expResult++;
        result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLength method, of class Wallet.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Wallet instance = new Wallet();
        int expResult = 10;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // review the generated test code and remove the default call to fail.
        instance.add(new ConcertTicket("Titanic", new Date("08/17/2019"), 18.5));
        result = instance.getLength();
        assertEquals(expResult, result);
    }
}
