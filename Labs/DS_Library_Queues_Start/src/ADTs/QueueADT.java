/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADTs;

import Exceptions.EmptyCollectionException;
/**
 * An interface for a Queue
 * Specific Queue implementations will implement this interface
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2019
 * @author ITCS 2214
 */
public interface QueueADT<T> extends CollectionADT<T> {
    /**
     * Adds the specified element to the tail or end of the queue
     * @param element element to be enqueued or appended into the queue
     */
    public void enqueue(T element);
    
    /**
     * Returns (without removing) the element that is in the head of the queue
     * @return the element in the head of the queue
     * @throws EmptyCollectionException 
     */
    public T first() throws EmptyCollectionException;
    
    /**
     * Removes and returns the element that is in the beginning or head of the stack
     * @return the element in the beginning or head of the stack
     * @throws EmptyCollectionException 
     */
    public T dequeue()throws EmptyCollectionException;
}
