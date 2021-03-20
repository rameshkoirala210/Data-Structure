/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import ADTs.ListADT;
import DataStructures.SinglyLinkedList;
import Exceptions.EmptyCollectionException;

/**
 *
 * @author ITSC 2214 and ITCS 6114
 */
public class Search {
    /**
     * TODO Walk through the given list and search for given target
     * If the target is found, return the index of the target in list
     * or else it returns -1.
    */
    public static <T extends Comparable<T>> int linearSearch(ListADT<T> list, T targetValue)
    throws Exception{
        //System.out.println(Arrays.toString(array));
        if (list == null) return -1;
        
        //TODO Walk through the given list and search for given target
        //if the target is found, return the index of the target in list
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).compareTo(targetValue) == 0){
                return i;
            }
        }
      return -1;
    }

    public static <T extends Comparable<T>> int linearSearch(T[] array, T targetValue) {
        //System.out.println(Arrays.toString(array));
        for (int i = 0; i< array.length; i++)
            if (array[i].compareTo(targetValue) == 0)
                return i;

        return -1;
    }
    
    public static <T extends Comparable<T>> int binarySearch(ListADT<T> list, T targetValue) {
        int low = 0;
        int high = list.size() - 1;
        int guess;

        try {
            while (low <= high){
                guess = (low + high) /2;
                if (list.get(guess).compareTo(targetValue) == 0)
                    return guess;
                else if (list.get(guess).compareTo(targetValue) < 0)
                    low = guess + 1;
                else
                    high = guess -1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	return -1;
    }
    
    public static <T extends Comparable<T>> int binarySearch(T[] array, T targetValue) {
        int low = 0;
        int high = array.length - 1;
        int guess;
        
        //TODO Narrows down the search space to its half till only
        //one element is left. In each iteration, compare the given
        //target with the element in the middle of the search range
        //If target is smaller than the element in the middle of the 
        //search subrange, narrow
        //down next search iteration into its left-half subrange.
        //If target is greater than the element in the middle of the 
        //search subrange, narrow
        //down next search iteration into its right-half subrange.
        //If target is equivilent to the element in the middle of the 
        //search subrange, return 
        // the index of the middle element.
        try {
            while (low <= high){
                guess = (low + high) /2;
                if (array[guess].compareTo(targetValue) == 0)
                    return guess;
                else if (array[guess].compareTo(targetValue) < 0)
                    low = guess + 1;
                else
                    high = guess -1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	return -1;
    }

    @SuppressWarnings("empty-statement")
    public static void main (String[] argv) {
        Integer array[] = { 3, 4, 5, 6, 7};
        System.out.println("LinearSearch in an array: " + Search.linearSearch(array, 5));
        System.out.println("BinarySearch in an array: " + Search.binarySearch(array, 5));
        
        ListADT<Integer> list = new SinglyLinkedList<Integer>();
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        try {
            System.out.println("LinearSearch in a List: " + Search.linearSearch(array, 5));
            System.out.println("BinarySearch in a List: " + Search.binarySearch(array, 5));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
