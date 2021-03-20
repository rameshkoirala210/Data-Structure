/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps;

import ADTs.ListADT;
import Algorithms.Search;
import Algorithms.Sort;
import DataStructures.SinglyLinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Vote management
 * @author ITSC 2214 Q
 * 
 */
public class VoteMan {
     private ListADT<Vote> votes;


    public VoteMan() {
        readVotes();
    }

    // private helper method to initialize data
    private void readVotes() {
        
        votes = new SinglyLinkedList<Vote>();
        //(String name, String state, int ID, String who2Vote)
        votes.addFirst(new Vote("Jason Aldean", "NC", 1, "Peter Pan"));
        votes.addFirst(new Vote("Panic at the Disco", "NC", 2, "Harry Potter"));
        votes.addFirst(new Vote("Phish", "FL", 1, "Harry Potter"));
        votes.addFirst(new Vote("Carrie Underwood", "NC", 3, "Peter Pan"));
        votes.addFirst(new Vote("Bonnie Raitt", "SC", 1, "Peter Pan"));
        votes.addFirst(new Vote("Needtobreathe", "FL", 2, "Harry Potter"));
        votes.addFirst(new Vote("Dolly Parton", "SC", 2, "Harry Potter"));
        votes.addFirst(new Vote("Trans-Siberian Orchestra", "FL", 3, "Harry Potter"));
        votes.addFirst(new Vote("Twney One Pilots", "NC", 4, "Harry Potter"));
    }

    /**
     * Examine whether the given vote information can be found
     */
    public void existVote(String state, int ID, String whom2vote) {
        Vote target = new Vote("", state, ID, whom2vote);

        int foundIndex = -1;
        try {
            foundIndex = Search.linearSearch(votes, target);
        } catch (Exception ex) {
            ex.getMessage();
        }
        if (foundIndex != -1) {
            System.out.println("Linear Search. Found vote at the index ");
            System.out.println("\t" + foundIndex);
        } else {
            System.out.println("Linear Search. Didn't find vote");
        }
    }

    /**
     * Sorts the votes stored by this VoteMan by states,
     * ascending.Doesn't print or return anything. 
     */
    public void sortByState() {
        //TODO sort votes by selection sort based on voting states
        

        System.out.println("Selection sort by states: \n" + this.toString());
        
        Sort.insertionSort(votes, Vote.Comparators.STATE);
        System.out.println("Insertion sort by states: \n" + this.toString());
        
        Sort.mergeSort(votes, 0, votes.size() - 1, Vote.Comparators.STATE);
        System.out.println("Merge sort by states: \n" + this.toString());
    }
    
    /**
     * Sorts the votes stored by this VoteMan by whom2vote
     */
    public void sortByWhom2vote() {
        //Arrays.sort(votes, Vote.Comparators.WHOM2VOTE);
        //Collection<Vote>.sort(votes, Vote.Comparators.WHOM2VOTE);
        //TODO sort 
        

        System.out.println("Selection sort by whom2vote: \n" + this.toString());
        
        Sort.insertionSort(votes, Vote.Comparators.WHOM2VOTE);
        System.out.println("Insertion sort by whom2vote: \n" + this.toString());
        
        Sort.mergeSort(votes, 0, votes.size() - 1, Vote.Comparators.WHOM2VOTE);
        System.out.println("Merge sort by whom2vote: \n" + this.toString());
    }

    /**
     * Retrieve all vote information     
     */
    @Override
    public String toString() {
        //return Arrays.toString(concertTickets);
        String list = new String();
        try {
            for (int i = 0; i < votes.size(); i++) {
                list = list.concat("\t" + votes.get(i).toString() + "\n" );
            }
        } catch (Exception ex){
            ex.getMessage();
        }
        return list;
    }
    
    public static void main(String argv[]){
        VoteMan voteman = new VoteMan();
        voteman.sortByState();
        voteman.sortByWhom2vote();
        voteman.existVote("FL", 1, "Harry Potter");
    }
}