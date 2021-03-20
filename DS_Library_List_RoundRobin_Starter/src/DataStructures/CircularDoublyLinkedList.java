package DataStructures;

import ADTs.ListADT;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
/**
 * 
 * @author ITSC 2214 Q.
 * @param <T> 
 * @version 1.0
 */
public class CircularDoublyLinkedList<T extends Comparable<T>> implements ListADT<T> {
    private DoublyLinkedNode<T> first;
    private int numNodes;

    /**
     * Constructor.
     */
    public CircularDoublyLinkedList() {
        first = null;
        numNodes = 0;
    }
    
    
    /**
     * Retrieve the first element in the circular list,
     * which is stored in the current first node
     * @return first element
     */
    @Override
    public T first() throws EmptyCollectionException{
        if (first == null)
            throw new EmptyCollectionException("CircularDoublyLinkedList");

        return first.getElement();
    }
    
    /**
     * retrieve the element of the current first node in the list
     * @return 
     */
    public T current(){
        if (first == null)
            return null;

        return first.getElement();
    }
    
    /**
     * Retrieve the last element in the list,
     * which next reference points to the current first node
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public T last() throws EmptyCollectionException{
        if (first == null)
            throw new EmptyCollectionException("CircularDoublyLinkedList");

        return first.getPrev().getElement();
    }

    @Override
    /**
     * Examine whether the circular list is empty.
    */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Print all elements in the list.
     */
    public void printList() {
        // Is list empty?
        if(first == null)
            return;

        // start at the head and print everyone
        boolean startFlag = true;
        for(DoublyLinkedNode tmp=first; (tmp != first) || startFlag;
                      tmp=tmp.getNext()) {
            System.out.println(tmp.getElement().toString());
            startFlag = false;
        }
    }
    
    /**
     * Add a new element in the end of the circular list,
     * which next reference points to the current first node.
     * @param element 
     */
    @Override
    public void addLast(T element) {
        //TODO create the new node
        //TODO adjust references for new node
        //TODO increase the numNodes variable
        if(numNodes == 0){
           DoublyLinkedNode<T> node = new DoublyLinkedNode<>(element);
            
            node.setNext(node);
            node.setPrev(node);
            
            first = node;
            
            numNodes = 1;
        }else{
            DoublyLinkedNode<T> node = new DoublyLinkedNode<>(element);
            node.setPrev(first.getPrev());
            first.getPrev().setNext(node);
            first.setPrev(node);
            node.setNext(first);

            numNodes++;
        }
    }
    /**
     * Add a new element in the beginning of the circular list,
     * which is represented as the current first node.
     */
    @Override
    public void addFirst(T element) {
        // create the new node
        //addLast(element);
         if(numNodes == 0){
            DoublyLinkedNode<T> node = new DoublyLinkedNode<>(element);
            
            node.setNext(node);
            node.setPrev(node);
            first = node;
            numNodes = 1;
        }else{
            DoublyLinkedNode<T> node = new DoublyLinkedNode<>(element);
            //TODO adjust the current first node reference 
            first.getPrev().setNext(node);
            node.setPrev(first.getPrev());
            node.setNext(first);
            first.setPrev(node);

            first = node;
            numNodes++;
        } 

    }
    
    /**
     * Insert a new node which holds the reference to the given element,
     * after the node which holds the given existing.
     * Namely insert the given element after the existing element in the list
        If the given existing is not found, throw an 
        ElementNotFoundException.

        Note: the CircularDoublyLinkedList class uses the data member variable first
        and numNodes to maintain the status of a CircularDoublyLinkedList instance.
        When the method addAfter is invoked, we need to make sure that the
        data member variable first, and numNodes are changed properly.
        Do we need to change the data member variable first?
        And when?
     * @param existing
     * @param element
     * @throws ElementNotFoundException
     * @throws EmptyCollectionException 
     */
    @Override
    public void addAfter(T existing, T element) throws ElementNotFoundException, EmptyCollectionException {
        DoublyLinkedNode<T> foundNode = find(existing);
        
        //TODO create a node and maintain all references 
        //insert the new node after the found node.
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(element);
       
         foundNode.getNext().setPrev(node);
         node.setNext(foundNode.getNext());
         
         foundNode.setNext(node);
         node.setPrev(foundNode);
         numNodes++;     
        
    }

    /**
     * Remove a node that holds the given element.
     * @param element
     * @return
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException 
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        DoublyLinkedNode<T> foundNode = find(element);
        
        //TODO remove the found node and maintain all
        //references, including the current first node reference
        if(foundNode.getElement().equals(first.getElement())){
            first = first.getNext();  
        }
       
       foundNode.getNext().setPrev(foundNode.getPrev());
       foundNode.getPrev().setNext(foundNode.getNext());
       numNodes--;
       return foundNode.getElement();
    }

    /**
     * Remove the first node in the list.
     * (prior to the current first node)
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        // case 1: empty list
        if(first == null)
            throw new EmptyCollectionException("CircularDoublyLinkedList");
        
        DoublyLinkedNode<T> tmp = first;
        if (this.numNodes == 1){ 
            //case 2
            first.setNext(null);
            first.setPrev(null);
            first = null;
        } else {
            //case 3
            first.getPrev().setNext(first.getNext());
            first.getNext().setPrev(first.getPrev());
            first = tmp.getNext();
        }
        numNodes--;
        // return a pointer to the removed node
        return tmp.getElement();
    }

    /**
     * Remove the last node in the list.
     * (prior to the current first node)
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        // TODO remove last node and maintain all references
        //      including the current first node reference.
        //case 1: empty list
        DoublyLinkedNode<T> tmp = first;
        if(numNodes == 0)
            throw new EmptyCollectionException("CircularDoublyLinkedList");
        if(numNodes == 1){
            first = null;
        }else{
        first.getPrev().getPrev().setNext(first);
        first.setPrev(first.getPrev().getPrev());
        }
        // return a pointer to the removed node
        numNodes--;
        return tmp.getElement();
    }

    /**
     * Examine whether the list includes the given element.
     * @param element
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public boolean contains(T element) throws EmptyCollectionException {
        //TODO refer to the printList method
        DoublyLinkedNode<T> temp = first;
         if(numNodes == 0)
            throw new EmptyCollectionException("CircularDoublyLinkedList");
        
        for(int i = 0;i < numNodes;i++){
            if(temp.getElement().equals(element)){
               return true; 
           }
           temp = temp.getNext();
        }
        
        return false;  
    }
    
    /**
     * Find the first node which holds the given element.
     * @param element
     * @return
     * @throws EmptyCollectionException 
     */
    public DoublyLinkedNode<T> find(T element) throws ElementNotFoundException, EmptyCollectionException {
        if (numNodes == 0)
            throw new EmptyCollectionException("CircularDoublyLinkedList");

        // walk through the list and find the given element in the list
        boolean startFlag = true;
        for(DoublyLinkedNode<T> tmp=first; (tmp != first) || startFlag;
                      tmp=tmp.getNext()) {
            startFlag = false;
            if (element.compareTo(tmp.getElement()) == 0)
                return tmp;
        }
        throw new ElementNotFoundException("CircularDoublyLinkedList"); 
    }
    
    /**
     * Retrieve the node at the given index of the list.
     * @param index
     * @return
     * @throws EmptyCollectionException
     * @throws InvalidArgumentException 
     */
    public DoublyLinkedNode<T> getNode(int index) throws EmptyCollectionException, InvalidArgumentException {
        if (numNodes == 0)
            throw new EmptyCollectionException("CircularDoublyLinkedList");

        if (index < 0 || index >= numNodes) 
            throw new InvalidArgumentException("CircularDoublyLinkedList");
        
        // TODO walk through the list till the given index
        DoublyLinkedNode<T> tmp=first;
        for (int count = 0; count < index; count++)
            tmp=tmp.getNext();

        return tmp;
    }
    
    /**
     * Change the current first node reference to its next node.
     */
    public void next() {
        if(this.first != null)
            first = first.getNext();
    }
    
    /**
     * Retrieve the element at the given index of the list.
     * @param index
     * @return
     * @throws EmptyCollectionException
     * @throws InvalidArgumentException 
     */
    @Override
    public T get(int index) throws EmptyCollectionException, InvalidArgumentException {
        DoublyLinkedNode<T> tmp = getNode(index);
        return tmp.getElement();
    }

    /**
     * Reset the element in the given index of the list.
     * @param index
     * @param element
     * @throws EmptyCollectionException
     * @throws InvalidArgumentException 
     */
    @Override
    public void set(int index, T element) throws EmptyCollectionException, InvalidArgumentException {
        DoublyLinkedNode<T> tmp = getNode(index);
        tmp.setElement(element);
    }

    /**
     * Return the total number of elements in the list.
     * @return 
     */
    @Override
    public int size() {
        return this.numNodes;
    }

    void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
