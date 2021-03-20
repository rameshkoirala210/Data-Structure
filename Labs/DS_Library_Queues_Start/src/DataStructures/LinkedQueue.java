package DataStructures;

import ADTs.QueueADT;
import DataStructures.SinglyLinkedNode;
import Exceptions.EmptyCollectionException;
/**
 *
 * @author ITCS2214
 */
public class LinkedQueue<T> implements QueueADT<T> {
    SinglyLinkedNode<T> front, rear;
    int count;
    
    public LinkedQueue(){
	   // Initialize data member variables front, rear and count
        front = rear = null;
        count = 0;
    }
    
    @Override
    public void enqueue(T element) {
        //TODO add a node which holds given element to the rear of queue. For example,
        //Create a new singly linear node, holding the reference to given element
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>(element);
        //if queue is empty, set front and rear to temp node. Or else
        if(rear == null){
            front = rear = temp;
        }else{
        //-set the next reference of the rear node to the new node
            rear.next = temp;
        //-set rear to point to the new node
            rear = temp;
        //Increment count
            count++;
        }
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Queue [first()]");
        }
        return front.getElement();
    }   

    @Override
    public T dequeue() throws EmptyCollectionException {
        //TODO remove node in the front of queue and return its held element. For example,
        //If queue is empty, throw an EmptyCollectionException exception.
        if (this.front == null) 
            throw new EmptyCollectionException("fff");
        //Declare a temporary node, temp and set it to be the same as front
        SinglyLinkedNode<T> temp = front;
        //Set front to the node next to the front
        this.front = this.front.next;
        //if queue is empty, set rear to null.
        if (this.front == null) 
            this.rear = null; 
        //Decrease count
        count --;
        //Return the data element of them temporary node
        return temp.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0? true : false;
    }

    @Override
    public int size() {
        return this.count;
    }
}
