/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import ADTs.QueueADT;
import Exceptions.EmptyCollectionException;
import java.util.Arrays;

/**
 *
 * @author ITSC 2214 Q
 */
public class ArrayQueue<T> implements QueueADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue; 
  
    /**
     * Creates an empty queue using the specified capacity.
     * @param initialCapacity the initial size of the circular array queue
     */
    public ArrayQueue (int initialCapacity)
    {
        front = rear = count = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }
  
    /**
     * Creates an empty queue using the default capacity.
     */
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }    
	
     /**
     * Adds the specified element to the rear of this queue, expanding
     * the capacity of the queue array if necessary.
     * @param element the element to add to the rear of the queue
     */
    public void enqueue(T element)
    {
        if (rear == queue.length) 
            expandCapacity();
    
        //TODO Adds the specified element to the rear of this queue 
        // and changes the rear and count variables correspondently
         queue[rear] = element;

        rear = (rear + 1) % this.queue.length;
    
        count++;



    }
	
     /**
     * Creates a new array to store the contents of this queue with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        T[] larger = (T[]) (new Object[queue.length *2]);
    
        for (int scan = 0; scan < count; scan++)
        {
            larger[scan] = queue[front];
            front = front + 1;
        }
    
        front = 0;
        rear = count;
        queue = larger;
    }
	
    /**
     * Removes the element at the front of this queue and returns a
     * reference to it. 
	 * @return the element removed from the front of the queue
     * @throws EmptyCollectionException  if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
    
        //TODO Removes the element at the front of this queue 
        //     and returns a reference to it.
        //     Not forgot to change the rear and count variables correspondently.
        T result = queue[front];
        queue[front] = null;
        
        this.front = (this.front - 1) % this.queue.length;
    
        count--;
    
        return result;   
    }
  
    /** 
     * Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.  
     * @return the first element in the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
        
        // TODO Returns a reference to the element at the front of this queue.
        return queue[front];
    }
  
    /**
     * Returns true if this queue is empty and false otherwise.
     * @return true if this queue is empty 
     */
    public boolean isEmpty()
    {
        // TODO Returns true if this queue is empty and false otherwise.
        if (count == 0)
            return true;
        else
            return false;

    }
  
    /**
     * Returns the number of elements currently in this queue.
     * @return the size of the queue
     */
    public int size()
    {
        // TODO Returns the number of elements currently in this queue.
         return count;

    }
  
    /**
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString()
    {
        String txt = "Number of elements in queues:" + this.size() + "\n";
        
        for (int i = 0; i < this.size(); i++)
            txt += queue[front + i].toString() + "\n";
        
        return txt;
    }
}
