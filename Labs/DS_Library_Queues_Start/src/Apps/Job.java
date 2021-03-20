package Apps;
import java.util.*;

public class Job implements Cloneable, Comparable<Job> {
    // jobs id number
    private int id;

    // time remaining for the job
    private int startTime;
    private int totalTime;
    private int runTime;

    /*
     * constructor
     */
    public Job(String line) {
        // parse the string
        StringTokenizer tok = new StringTokenizer(line);

        // simple check for correctness
        if(tok.countTokens() != 3) {
            System.err.println("Error: invalid test file format.");
            System.exit(1);
        }

        /*
        * first token - job id number
        * second token - arrival time
        * third token - total run time needed
        * NOTE: no token format verification performed - not real robust :(
        */

        // get the job's id number
        id = Integer.parseInt(tok.nextToken());

        // get the start time
        startTime = Integer.parseInt(tok.nextToken());

        // get the total run time
        totalTime = Integer.parseInt(tok.nextToken());

        // set the time it has run so far
        runTime = 0;
    }

    /*
     * getStart
     */
    public int getStart() {
        return startTime;
    }

    /*
     * getRemaining
     */
    public int getRemaining() {
        return totalTime - runTime;
    }

    /*
     * updateRemaining
     */
    public void updateRunTime(int lastRunTime) {
        runTime += lastRunTime;
    }

    /*
     * clone
     */
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e) {}
        return obj;
    }
    
    /**
     * retrieve the id
     * @return 
     */
    public int getID(){
        return this.id;
    }

    /*
     * toString
     */
    public String toString() {
        String s = new String("  Job " + id + ": start = " + startTime + "; total needed = " + totalTime + "; running time = " + runTime);
        return s;
    }

    /**
     * compareable 
     * @param another
     * @return 
     */
    @Override
    public int compareTo(Job another) {
        if (this.id == another.getID())
            return 0;
        else if (this.id > another.getID())
            return 1;
        else
            return -1;
    }
}
