/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Qiong
 */
public class SchedulerTest {
    
    public SchedulerTest() {
    }

    @Test
    public void testAll() {
        /*
        Properties p = System.getProperties();
        Enumeration keys = p.keys();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = (String)p.get(key);
            System.out.println(key + ": " + value);
        }
        */
        // input test file 
        int[] testlist = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int index = 0; index < testlist.length; index++){
            String inputF = "test-" + testlist[index] + ".dat";
            String expectF = "test-" + testlist[index] + ".results";
            String expectLine = null;

            final String dir = System.getProperty("user.dir");
            System.out.println("current dir = " + dir);
            System.out.println("current class = " + this.getClass().toString());
            //ClassLoader loader = SchedulerTest.class.getClassLoader();
            //System.out.println(loader.getResource("Apps/Scheduler.class"));
            //System.out.println(loader.getResource("Apps/SchedulerTest.class"));

            String command = "java -cp " + dir + "/build/classes/ " + "Apps.Scheduler " + dir + "./" + inputF;
            //String command = "java -cp . Apps.Scheduler " + dir + "./" + inputF;
            System.out.println("command: " + command);
            try {
                System.out.println("Output:");
                BufferedReader testFile = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(expectF)));

                Process process = Runtime.getRuntime().exec(command);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                String line;
                int count = 0;
                while ((line = reader.readLine()) != null) {
                    expectLine = testFile.readLine();

                    if (! expectLine.equalsIgnoreCase(line)){
                        System.out.println("Output:" + line);
                        System.out.println("Expected:" + expectLine);
                        fail("Not match!");
                    }
                    count++;
                }
                System.out.println("Test " + testlist[index] + " passed. " + count + " lines are same");

                reader.close();
                testFile.close();

            } catch (IOException e) {
                e.printStackTrace();
                fail("Error");
            }
        }
    }
    
}
