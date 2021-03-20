/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * A node of chains 
 * @author ITSC 2214
 * @version 1.0
 * @param <K> key
 * @param <V> value
 */
class HashNode<K, V> { 
    private K key; 
    private V value; 
  
    /** TODO Reference to next node  */
    private HashNode<K, V> next; 
  
    /** Default constructor  * */
    private HashNode() { 
    }
    
    /**
     * Constructor
     * @param key key of a key-value pair
     * @param value value of a key-value pair
     */
    public HashNode(K key, V value) { 
        this.key = key; 
        this.value = value; 
    } 
    
    /**
     * Retrieve the key of the pair
     * @return the key
     */
    public K getKey() {
        return this.key;
    }
    
    /**
     * Retrieve the value of the pair
     * @return the value
     */
    public V getValue() {
        return this.value;
    }
    
    /**
     * Reset the value of the pair to another key
     * @param anotherValue value of another pair
     */
    public void setValue(V anotherValue) {
        this.value = anotherValue;
    }
    
    /**
     * Retrieve the reference to next node
     * @return the reference to next node
     */
    public HashNode<K, V> getNext() {
        return this.next;
    }
    
     /**
     * Reset the reference to next node
     * @param anotherNext reference of another pair
     */
    public void setNext(HashNode<K, V> anotherNext) {
        this.next = anotherNext;
    }
} 