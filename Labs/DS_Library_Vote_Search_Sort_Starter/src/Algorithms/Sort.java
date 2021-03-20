package Algorithms;

import ADTs.ListADT;
import DataStructures.SinglyLinkedList;
import java.util.Comparator;

public class Sort {
    //TODO selection sort
    public static <T extends Comparable<T>> void selectionSort(ListADT<T> list, Comparator<T> comparator) {
        try {
          for (int i = 0; i < list.size(); i++) {
            int smallestIndex = i;
            T smallest = list.get(i);
            for (int j = 1; j < list.size() - i; j++) {
                if (list.get(j).compareTo(smallest) < 0){
                    smallestIndex = j;
                    smallest = list.get(j);
                } 
            }    
            
            if (smallestIndex != i) {
                // Swap numbers[array.length - i - 1] and numbers[index4Max]
                T temp = list.get(i);
                list.set(i, smallest);
                list.set(smallestIndex, temp);
                }
              
          }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // selection sort
    public static <T extends Comparable<T>> void selectionSort(ListADT<T> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
            // find index of largest element
                int index4Max = i;
                for (int j = 1; j < list.size() - i; j++) 
                    if (list.get(j).compareTo(list.get(index4Max)) >= 0) 
                        index4Max = j;
                
                if (index4Max != i) {
                    // Swap numbers[array.length - i - 1] and numbers[index4Max]
                    T temp = list.get(list.size() - i - 1);
                    list.set(list.size() - i - 1, list.get(index4Max));
                    list.set(index4Max, temp);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static <T extends Comparable<T>> void insertionSort(ListADT<T> list, Comparator<T> comparator) {
        int j;
        T target;
        try {
            for (int i = 1; i < list.size(); ++i) {
              // Insert numbers[i] into sorted part 
              // stopping once numbers[i] in correct position
              target = list.get(i);
              for (j = i-1; j>=0 && comparator.compare(list.get(j), target) >0; j--)
                  list.set(j+1, list.get(j));

              list.set(j+1, target);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static <T extends Comparable<T>> void insertionSort(ListADT<T> list) {
        int j;
        T target;
        try {
            for (int i = 1; i < list.size(); ++i) {
              // Insert numbers[i] into sorted part 
              // stopping once numbers[i] in correct position
              target = list.get(i);
              for (j = i-1; j>=0 && list.get(j).compareTo(target)>0; j--)
                  list.set(j+1, list.get(j));

              list.set(j+1, target);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static <T extends Comparable<T>> void merge(ListADT<T> list, int i, int j, int k, Comparator<T> comparator) {
       int mergedSize = k - i + 1;       // Size of merged partition
       ListADT<T> mergedList = new SinglyLinkedList<T>(); // Temporary array for merged numbers
      
       int mergePos;                     // Position to insert merged number
       int leftPos;                      // Position of elements in left partition
       int rightPos;                     // Position of elements in right partition

       mergePos = 0;
       leftPos = i;                      // Initialize left partition position
       rightPos = j + 1;                 // Initialize right partition position

       // Add smallest element from left or right partition to merged numbers
       try {
            for (int count = 0; count < list.size(); count++){
                mergedList.addLast(list.get(count));
            }
        while (leftPos <= j && rightPos <= k) {
           if (comparator.compare(list.get(leftPos), list.get(rightPos)) < 0) {
              mergedList.set(mergePos, list.get(leftPos));
              ++leftPos;
           } 
           else {
              mergedList.set(mergePos, list.get(rightPos));
              ++rightPos;
           }
           ++mergePos;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
           mergedList.set(mergePos, list.get(leftPos));
           ++leftPos;
           ++mergePos;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
           mergedList.set(mergePos, list.get(rightPos));
           ++rightPos;
           ++mergePos;
        }

        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
           list.set(i + mergePos, mergedList.get(mergePos));
        }
       } catch (Exception ex){
           ex.printStackTrace();
       }
    }

    public static <T extends Comparable<T>> void mergeSort(ListADT<T> list, int i, int k, Comparator<T> comparator) {
       int j;

       if (i < k) {
          j = (i + k) / 2;  // Find the midpoint in the partition

          // Recursively sort left and right partitions
          mergeSort(list, i, j, comparator);
          mergeSort(list, j + 1, k, comparator);

          // Merge left and right partition in sorted order
          merge(list, i, j, k, comparator);
       }
    }
    
    public static <T extends Comparable<T>> void merge(ListADT<T> list, int i, int j, int k) {
       int mergedSize = k - i + 1;       // Size of merged partition
       ListADT<T> mergedList = new SinglyLinkedList<T>(); // Temporary array for merged numbers
      
       int mergePos;                     // Position to insert merged number
       int leftPos;                      // Position of elements in left partition
       int rightPos;                     // Position of elements in right partition

       mergePos = 0;
       leftPos = i;                      // Initialize left partition position
       rightPos = j + 1;                 // Initialize right partition position

       // Add smallest element from left or right partition to merged numbers
       try {
            for (int count = 0; count < list.size(); count++){
                mergedList.addLast(list.get(count));
            }
        while (leftPos <= j && rightPos <= k) {
           if (list.get(leftPos).compareTo(list.get(rightPos)) < 0) {
              mergedList.set(mergePos, list.get(leftPos));
              ++leftPos;
           } 
           else {
              mergedList.set(mergePos, list.get(rightPos));
              ++rightPos;
           }
           ++mergePos;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
           mergedList.set(mergePos, list.get(leftPos));
           ++leftPos;
           ++mergePos;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
           mergedList.set(mergePos, list.get(rightPos));
           ++rightPos;
           ++mergePos;
        }

        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
           list.set(i + mergePos, mergedList.get(mergePos));
        }
       } catch (Exception ex){
           ex.printStackTrace();
       }
    }

    public static <T extends Comparable<T>> void mergeSort(ListADT<T> list, int i, int k) {
       int j;

       if (i < k) {
          j = (i + k) / 2;  // Find the midpoint in the partition

          // Recursively sort left and right partitions
          mergeSort(list, i, j);
          mergeSort(list, j + 1, k);

          // Merge left and right partition in sorted order
          merge(list, i, j, k);
       }
    }
   
    public static void main(String [] args) {
      //int numbers [] = {10, 2, 78, 4, 45, 32, 7, 11};
      //final int NUMBERS_SIZE = 8;
      System.out.println("-----------Selection Sort---------\nUNSORTED: ");
      SinglyLinkedList<Integer> numbers1 = new SinglyLinkedList<Integer>();
      numbers1.addLast(10);
      numbers1.addLast(2);
      numbers1.addLast(78);
      numbers1.addLast(4);
      numbers1.addLast(45);
      numbers1.addLast(32);
      numbers1.addLast(7);
      numbers1.addLast(11);
      System.out.println(numbers1.toString());

      /* initial call to quicksort with index */
      selectionSort(numbers1);

      System.out.println("SORTED: ");
      System.out.println(numbers1.toString());
      
      System.out.println("-----------Insertion Sort---------\nUNSORTED: ");
      SinglyLinkedList<Integer> numbers2 = new SinglyLinkedList<Integer>();
      numbers2.addLast(10);
      numbers2.addLast(2);
      numbers2.addLast(78);
      numbers2.addLast(4);
      numbers2.addLast(45);
      numbers2.addLast(32);
      numbers2.addLast(7);
      numbers2.addLast(11);
      System.out.println(numbers2.toString());

      /* initial call to quicksort with index */
      insertionSort(numbers2);

      System.out.println("SORTED: ");
      System.out.println(numbers2.toString());
      
      System.out.println("-----------Merge Sort---------\nUNSORTED: ");
      SinglyLinkedList<Integer> numbers3 = new SinglyLinkedList<Integer>();
      numbers3.addLast(10);
      numbers3.addLast(2);
      numbers3.addLast(78);
      numbers3.addLast(4);
      numbers3.addLast(45);
      numbers3.addLast(32);
      numbers3.addLast(7);
      numbers3.addLast(11);
      System.out.println(numbers3.toString());

      /* initial call to quicksort with index */
      mergeSort(numbers3, 0, numbers3.size() - 1);

      System.out.println("SORTED: ");
      System.out.println(numbers3.toString());
    }
}