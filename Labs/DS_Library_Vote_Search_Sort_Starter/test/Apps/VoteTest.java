package Apps;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class VoteTest {
    
    public VoteTest() {
    }

    /**
     * Test of toString method, of class Vote.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vote instance = new Vote("name","state",0,"who2vote");
        String expResult = "name:state:0:who2vote";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Vote.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Vote o = new Vote("name1","state",00,"who2vote");
        Vote o1 = new Vote("name","state",01,"who2vote");
        Vote o2 = new Vote("name","state",02,"who2vote");
        Vote instance = new Vote("name","state",01,"who2vote");
        int result = instance.compareTo(o);
        assertEquals(1, result);
        result = instance.compareTo(o1);
        assertEquals(0, result);
        result = instance.compareTo(o2);
        assertEquals(-1, result);
    }
    
    /**
     * Test of Comparator for State
     */
    @Test
    public void testStateComparator() {
        Vote vote1 = new Vote("A", "NC", 1, "Harry Potter");
        Vote vote2 = new Vote("A", "FL", 1, "Harry Potter");
        Vote vote3 = new Vote("A", "NC", 2, "Harry Potter");
        assertTrue(Vote.Comparators.STATE.compare(vote1, vote2) > 0);
        assertTrue(Vote.Comparators.STATE.compare(vote1, vote1) == 0);  
        assertFalse(Vote.Comparators.STATE.compare(vote1, vote2) < 0);
        assertTrue(Vote.Comparators.STATE.compare(vote1, vote3) < 0);
    }
    
    /**
     * Test of Comparator for ID
     */
    @Test
    public void testIDComparator() {
        Vote vote1 = new Vote("A", "NC", 1, "Harry Potter");
        Vote vote2 = new Vote("A", "FL", 1, "Harry Potter");
        Vote vote3 = new Vote("A", "NC", 2, "Harry Potter");
        assertTrue(Vote.Comparators.ID.compare(vote1, vote2) == 0);
        assertTrue(Vote.Comparators.ID.compare(vote1, vote1) == 0);  
        assertTrue(Vote.Comparators.ID.compare(vote1, vote3) < 0);
        assertTrue(Vote.Comparators.ID.compare(vote3, vote1) > 0);
    }
    
    /**
     * Test of Comparator for Who2Vote
     */
    @Test
    public void testWhom2VoteComparator() {
        Vote vote1 = new Vote("A", "NC", 1, "Harry Potter");
        Vote vote2 = new Vote("A", "FL", 1, "Albus Dumbledor");
        Vote vote3 = new Vote("A", "NC", 2, "Hermione Granger");
        assertTrue(Vote.Comparators.WHOM2VOTE.compare(vote1, vote2) > 0);
        assertTrue(Vote.Comparators.WHOM2VOTE.compare(vote1, vote1) == 0);  
        assertTrue(Vote.Comparators.WHOM2VOTE.compare(vote1, vote3) < 0);
        assertTrue(Vote.Comparators.WHOM2VOTE.compare(vote3, vote1) > 0);
    }
    
}
