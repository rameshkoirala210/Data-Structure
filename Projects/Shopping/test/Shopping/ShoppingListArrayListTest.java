package Shopping;

import DataStructures.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public class ShoppingListArrayListTest {

    //private ShoppingListArrayList instance;

    /**
     * Initialize instance and entries
     */
    @Before
    public void setupTestCases() {
        //instance = new ShoppingListArrayList();
    }

    /**
     * TODO To Complete the test of add method, of class ShoppingArray.
     */
    @Test
    public void testAdd() {
        //Create grocery objects and a shopping list instance
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 
                15.5f, 2);
        Grocery item2 = new Grocery(item1);
        item2.setQuantity(3);
 
        ShoppingListArrayList instance = new ShoppingListArrayList();

        // TODO test the add method for the case of adding a new item (item1) into list instance 
        // Be sure that 1) size is increased by 1 and 
        //              2) the first item in the list 
        // is the same as in the reference variable, item1 
        
        assertEquals(0, instance.size());
        assertFalse(instance.contains(item1));
        
        instance.add(item1);
        
        assertEquals(1, instance.size());
        assertTrue(instance.contains(item1));

        
        // TODO test the "combine" feature of the add method
        // for the case of adding an existing entry, the item2
        // into the shopping list instance created in previous 
        // code block. The item2 has the same entry name as the item1.
        // Be sure that 1) size is not changed and 2) quantities are
        // properly changed in the first item in the list.
        
        instance.add(item2);
        
        assertEquals(1, instance.size());
        try{
            assertEquals(5, instance.find(0).getQuantity());
        }catch (EmptyCollectionException e) {
            fail("It's Empty");
        }




        
        // Test adding a null entry reference to the shpping list
        instance.add(null);
        assertTrue(1 == instance.size());
        
        // Test creating and adding a new grocery object to the list
        // Be sure that 1) the shopping list has a proper number of items
        //              2)the list item in the list 
        // is the same as in the newly created grocery object
        Grocery item3 = new Grocery("Laugh in the Rains", "book", 3, 
                35.5f, 1);
        instance.add(item3);
        System.out.println("Test..." + instance.size());
        assertTrue(2 == instance.size());
        try{
            assertTrue(item3.compareTo(instance.find(1)) == 0);
            assertTrue(1 == item3.getQuantity());
            assertTrue(1 == instance.find(1).getQuantity());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * TODO To Complete the test of remove method, of class ShoppingArrayList.
     */
    @Test
    public void testRemove() {
        //Create grocery objects
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 
                15.5f, 2);
        Grocery item2 = new Grocery("Hunger Game", "book", 3, 
                10.5f, 3);
        
        // Construct a shopping list
        ShoppingListArrayList instance = new ShoppingListArrayList();
        instance.add(item1);
        instance.add(item2);
        assertTrue(2 == instance.size());

        // TODO test the remove method for an existing entry
        // Be sure that 
        // 1) the returned value from the remove method is true
        // 2) the shopping list is decreased by 1
        // 3) the item being removed can not be found in the shopping list
        
            assertTrue(instance.remove(item1));
            assertEquals(1, instance.size());
            assertFalse(instance.contains(item1));

        // TODO test the remove method for a non-existing entry 
        // Be sure that 
        // 1) the returned value from the remove method is false
        // 2) the shopping list is not changed
            assertFalse(instance.remove(item1));
            assertEquals(1, instance.size());

        
        // Construct a case that the shopping list becomes empty
        boolean isRemoved = instance.remove(item2);
        assertTrue(isRemoved == true);
        assertTrue(0 == instance.size());
        
        // Test the remove method when the shopping list is empty
        isRemoved = instance.remove(item2);
        assertTrue(isRemoved == false);
        assertTrue(0 == instance.size());
    }

    /**
     * TODO To Complete the test of find method, of class ShoppingArrayList.
     */
    @Test
    public void testFind() {
        //Create grocery objects
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 
                15.5f, 2);
        Grocery item2 = new Grocery("Hunger Game", "book", 3, 
                10.5f, 3);
        
        // Construct a shopping list
        ShoppingListArrayList instance = new ShoppingListArrayList();
        
        // TODO Test the case of finding a grocery object when the shopping list is empty
        // Be sure that
        // An EmptyCollectionException instance is thrown in the case
        try{
            instance.find(0);
            fail("Shopping list not empty");
        }catch (EmptyCollectionException e) {
            assertTrue(e.toString().contains("ECE - find"));
        }
        
        // Add item1 into the shopping list
        instance.add(item1);
        instance.add(item2);
        assertTrue(2 == instance.size());
        
        // TODO Test the case of finding a grocery object which index is larger than the shopping list size
        // Be sure that
        // An IndexOutOfBoundsException instance is thrown in the case

        try{
            instance.find(2);
            fail("index is larger than the shopping list size");
        }catch (IndexOutOfBoundsException e) {
            assertTrue(e.toString().contains("IndexOutOfBoundsException"));
        } catch (EmptyCollectionException e){
            fail("caught EmptyCollectionException not IndexOutofBounds");
        }





        
        // Test the case of finding a grocery object which index is negative
        try{
            Grocery item = instance.find(-5);
            assertTrue(0 == 1);
        } catch (IndexOutOfBoundsException ex){
            assertTrue(1 == 1);
        } catch (Exception ex){
            assertTrue(0 == 1);
        }
        
        // Test the case of finding a grocery object which index is negative
        try{
            Grocery item = instance.find(0);
            assertTrue(item1.compareTo(item) == 0);
        } catch (IndexOutOfBoundsException ex){
            assertTrue(0 == 1);
        } catch (EmptyCollectionException ex){
            assertTrue(0 == 1);
        } catch (Exception ex){
            assertTrue(0 == 1);
        }
    }

    /**
     * Test of indexOf method, of class ShoppingArrayList.
     */
    @Test
    public void testIndexOf() {
        //Create grocery objects
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 
                15.5f, 2);
        Grocery item2 = new Grocery("Hunger Game", "book", 3, 
                10.5f, 3);
        
        // Construct an empty shopping list
        ShoppingListArrayList instance = new ShoppingListArrayList();
        
        // Check the indexOf method when the shopping list is empty
        try{
            int index = instance.indexOf(item1);
        } catch (ElementNotFoundException ex){
            assertTrue(1 == 1);
        } catch (Exception ex){
            assertTrue(0 == 1);
        }
        
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the indexOf method when the grocery item appears in the list
        try{
            int index = instance.indexOf(item2);
            assertTrue(1 == 1);
            assertTrue(index == 1);
            index = instance.indexOf(item1);
            assertTrue(1 == 1);
            assertTrue(index == 0);
        } catch (ElementNotFoundException ex){
            assertTrue(0 == 1);
        } catch (Exception ex){
            assertTrue(0 == 1);
        }
        
        // Check the indexOf method when the grocery item does not appear in the list
        try{
            Grocery item3 = new Grocery("Aladin", "book", 3, 
                15.5f, 2);
            int index = instance.indexOf(item3);
        } catch (ElementNotFoundException ex){
            assertTrue(1 == 1);
        } catch (Exception ex){
            assertTrue(0 == 1);
        }
        
        // Check the indexOf method when the grocery item is null
        try{
            Grocery obj = null;
            int index = instance.indexOf(obj);
        } catch (ElementNotFoundException ex){
            assertTrue(1 == 1);
        } catch (Exception ex){
            ex.printStackTrace();
            assertTrue(0 == 1);
        }
    }

    /**
     * Test of contains method, of class ShoppingArrayList.
     */
    @Test
    public void testContains() {
        //Create grocery objects
        Grocery item1 = new Grocery("Harry Potter", "book", 3, 
                15.5f, 2);
        Grocery item2 = new Grocery("Hunger Game", "book", 3, 
                10.5f, 3);
        
        // Construct a shopping list
        ShoppingListArrayList instance = new ShoppingListArrayList();
        
        // Check the contains method when the shopping list is empty
        boolean isTrue = instance.contains(item1);
        assertFalse(isTrue);
        
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the contains method when the grocery item appears in the list
        isTrue = instance.contains(item2);
        assertTrue(isTrue);
        
        // Check the contains method when the grocery item does not appear in the list
        Grocery item3 = new Grocery("Aladin", "book", 3, 
                15.5f, 2);
        isTrue = instance.contains(item3);
        assertFalse(isTrue);
        
        // Check the contains method when the grocery item is null
        Grocery obj = null;
        isTrue = instance.contains(obj);
        assertFalse(isTrue);
    }

    /**
     * Test of size method, of class ShoppingArrayList.
     */
    @Test
    public void testSize() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        ShoppingListArrayList instance = new ShoppingListArrayList();

        assertEquals(0, instance.size());

        instance.add(entry1);

        // Test increment
        assertEquals(1, instance.size());

        assertTrue(instance.remove(entry1));

        // Test decrement
        assertEquals(0, instance.size());
    }

    /**
     * Test of isEmpty method, of class ShoppingArrayList.
     */
    @Test
    public void testIsEmpty() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        ShoppingListArrayList instance = new ShoppingListArrayList();

        // Test empty
        assertTrue(instance.isEmpty());

        instance.add(entry1);

        // Test not empty
        assertFalse(instance.isEmpty());
    }
}