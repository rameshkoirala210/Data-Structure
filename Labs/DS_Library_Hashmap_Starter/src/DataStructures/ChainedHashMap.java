/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
import java.util.ArrayList; 
  
/** 
 * Class to represent entire hash table 
 * 
 * @author ITSC 2214
 * @param <K> key
 * @param <V> value
 * @version 1.0
 */
public class ChainedHashMap<K, V> { 
    /** bucketArray is used to store array of chains  **/
    private ArrayList<HashNode<K, V>> bucketArray; 
  
    /** Current capacity of array list  **/
    private int numBuckets; 
  
    /** Current size of array list  **/
    private int size; 
  
    /**
     * Constructor (Initializes capacity, size and 
     * empty chains. 
     * */
    public ChainedHashMap() { 
        numBuckets = 16;
        bucketArray = new ArrayList<>(numBuckets); 
        size = 0; 
  
        // TODO initialize every bucket of 
        // bucketArray with empty chains
        for ( int i = 0; i < numBuckets; i++ )
            bucketArray.add(null);


    } 
  
    /**
     * Retrieve the size of map
     * @return size
     */
    public int size() { 
        return size; 
    } 
    
    /**
     * TODO Examine whether the map collection is empty
     * @return true empty map
     *         false not empty map
     */
    public boolean isEmpty() { 
        //TODO return true if the map size is zero
        //     else return false
        return size == 0 ? true : false;
    } 
  
    /**
     * TODO Identify the bucket index for the given key,
     * in which the key-value pair can be searched for or found
     * or insertion or deletion
     * @param key a key
     * @return  index of array element where key-value 
     * pair can be found
     */
    private int getBucketIndex(K key) { 
        int hashCode = key.hashCode(); 
        
        // TODO return hashCode % numBuckets
        return hashCode % numBuckets;

    } 
  
    /** 
     * Method to remove a given key 
     * @param key a key
     * @return value of array element where key-value 
     * pair can be found
     */
    public V remove(K key) { 
        // Apply hash function to find index for given key 
        int bucketIndex = getBucketIndex(key); 
  
        // Get head of chain 
        HashNode<K, V> head = bucketArray.get(bucketIndex); 
  
        // Search for key in its chain 
        HashNode<K, V> prev = null; 
        while (head != null) { 
            // If Key found 
            if (head.getKey().equals(key)) 
                break; 
  
            // Else keep moving in chain 
            prev = head; 
            head = head.getNext(); 
        } 
  
        // If key was not found there 
        if (head == null) 
            return null; 
  
        // Reduce size 
        size--; 
  
        // Remove key 
        if (prev != null) 
            prev.setNext(head.getNext()); 
        else
            bucketArray.set(bucketIndex, head.getNext()); 
  
        return head.getValue(); 
    } 
  
    /**
     * TODO Returns associated value for a key 
     * @param key key
     * @return associated value
     * */
    public V get(K key) { 
        // TODO Locate bucket index for given key 
        int bucketIndex = getBucketIndex(key);

        
        // TODO Retrieve the head of chain  (the ArrayList 
        // variable, bucketArray) at a bucket index by using 
        // the get() method of the built-in ArrayList class
        HashNode<K, V> head = bucketArray.get(bucketIndex);

  
        // TODO Walk through the chain and search key
        // If the key is found, return its associated value
        // or else continue to walk through the chain until
        // the end of the chain
        while (head != null) { 
            if (head.getKey().equals(key)) 
                return head.getValue(); 
  
            head = head.getNext(); 
        } 

  
        // If key not found 
        return null; 
    } 
  
    /**
     * TODO Adds a key value pair to hash 
     * To avoid having many buckets with multiple values, 
     * the capacity is doubled if 70% (the load factor) 
     * of the buckets become non-empty. The default value 
     * for the load factor is 70%, and the default initial
     * capacity is 16.
     * @param key    a new pair with a key
     * @param value  a value associated with the key
     * */
    public void add(K key, V value) { 
        // Find head of chain for given key 
        int bucketIndex = getBucketIndex(key); 
        HashNode<K, V> head = bucketArray.get(bucketIndex); 
  
        // Check if key is already present 
        while (head != null) { 
            if (head.getKey().equals(key)) { 
                head.setValue(value);
                return; 
            } 
            head = head.getNext(); 
        } 
  
        // TODO Locate bucket chain based on bucket index,
        // insert key-value pair in the beginning of the 
        // bucket chain, changing the bucket chain head,
        // and increase the size by 1
        // step 1. todo increasing the size by 1
        size++;

        // step 2. todo retrieve the bucket chain head and
        //         save to the head variable
        head = bucketArray.get(bucketIndex);

        // step 3. todo create a hash node holding the pair of
        //         key and value
        HashNode<K, V> newNode = new HashNode<K, V>(key, value); 

        // step 4. todo assign new Node's next reference to the 
        //         head
        newNode.setNext(head);

        
        // step 5. todo assign the chain started with newNode to 
        //         bucketArray at the buketIndex
        bucketArray.set(bucketIndex, newNode);

  
        // If load factor goes beyond threshold, then 
        // double hash table size 
        if ((1.0 * size) / numBuckets >= 0.7) { 
            ArrayList<HashNode<K, V>> temp = bucketArray; 
            bucketArray = new ArrayList<>(); 
            numBuckets = 2 * numBuckets; 
            size = 0; 
            for (int i = 0; i < numBuckets; i++) 
                bucketArray.add(null); 
  
            for (HashNode<K, V> headNode : temp) { 
                while (headNode != null) { 
                    add(headNode.getKey(), headNode.getValue()); 
                    headNode = headNode.getNext(); 
                } 
            } 
        } 
    } 
  
    /**
     * Driver method to test Map class 
     * @param args arguments
     * */
    public static void main(String[] args) { 
        ChainedHashMap<String, Integer> map = 
                new ChainedHashMap<String, Integer>(); 
        map.add("this", 1); 
        map.add("coder", 2); 
        map.add("this", 4); 
        map.add("hi", 5); 
        System.out.println(map.size()); 
        System.out.println(map.remove("this")); 
        System.out.println(map.remove("this")); 
        System.out.println(map.size()); 
        System.out.println(map.isEmpty()); 
    } 
} 
