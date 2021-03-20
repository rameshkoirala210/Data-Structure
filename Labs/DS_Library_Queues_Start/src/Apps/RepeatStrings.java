/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps;

import ADTs.QueueADT;
import DataStructures.ArrayStack;
import ADTs.StackADT;
import DataStructures.LinkedQueue;
import java.util.Scanner;

/**
 *
 * @author Qiong
 */
public class RepeatStrings {
public static void main(String[] argv) throws Exception{
        final  int SIZE = 3;
        Scanner keyboard = new Scanner(System.in);
        
        QueueADT<String> stringQueue;
        //stringQueue = new CircularArrayQueue<String>(SIZE);
        stringQueue = new LinkedQueue<String>();
        StackADT<String> stringStack;
        stringStack = new ArrayStack<String>(SIZE);
        
        String line;
        for (int i = 0; i < SIZE; i++){
            System.out.print("Enter a line of text which includes only 3 words > ");
            line = keyboard.nextLine();
            
            //TODO enque the new element
            stringQueue.enqueue(line);
            
            //TODO push the new element
            stringStack.push(line);
            
        }
        
        System.out.println("\nOrder is: ");
        for (int i = 0; i < SIZE; i++){
            // TODO Remove an element in the order in which we input strings
            // Save it to the String variable, named line
            line = stringQueue.dequeue();
            
           
            System.out.println(line);
        }
        
        System.out.println("\nOpposite order is: ");
        for (int i = 0; i < SIZE; i++){
            // TODO Remove an element in the order opposite to they were entered
            // Save it to the String variable, named line
            line = stringStack.pop();
            
            System.out.println(line);
        }
    }
}

