/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps.salary;

import DataStructures.ChainedHashMap;
import java.util.Scanner;

/**
 * User-salary hash map
 * @author ITSC 2214
 * @version 1.0 
 */
public class SalaryMap extends ChainedHashMap<User, Double> {
    /**
     * Default constructor
     */
    private SalaryMap() {
    }
    
    /**
     * main entry method
     * @param argc arguments
     */
    public static void main(String[] argc) {
        SalaryMap map = new SalaryMap();
        int op = 0;
        double salary = 0;
        Double value;
        long id = 1;
        long userid;
        String name;
        String email;
        User user;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------");
            System.out.println("Operations on Hash Table");
            System.out.println("----------------------");
            System.out.println("1.Insert element into the table"); 
            System.out.println("2.Search element from the key");  
            System.out.println("3.Delete element at a key");  
            System.out.println("4.Exit");  
            System.out.print("Enter your choice: ");
            op = input.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Enter user name: ");
                    name = input.next();  
                    System.out.print("Enter user email: ");
                    email = input.next();
                    user = new User(id++, name, email);
                    System.out.print("Enter user salary: ");
                    salary = input.nextDouble(); 
                    map.add(user, salary);
                    System.out.println("Add user: " + user.toString());
                    break;
                case 2:
                    System.out.print("Enter user id: ");
                    userid = input.nextInt();
                    System.out.print("Enter user name: ");
                    name = input.next();  
                    System.out.print("Enter user email: ");
                    email = input.next();
                    user = new User(userid, name, email);
                    value = map.get(user);
                    if (value == null)
                        System.out.println("Record is not found! ");
                    else    
                        System.out.println("Record is found! " + 
                            name + "'s salary is $"
                            + value.doubleValue());
                    break;
                case 3:
                    System.out.print("Enter user id: ");
                    userid = input.nextInt();
                    System.out.print("Enter user name: ");
                    name = input.next();  
                    System.out.print("Enter user email: ");
                    email = input.next();
                    user = new User(userid, name, email);
                    value = map.remove(user);
                    if (value == null)
                        System.out.println("Record is not found! ");
                    else 
                        System.out.println("Remove the record for "
                                + name + ", whose salary is $"
                                + value.doubleValue());
                    break;
                case 4:
                    return;
                default:
            }
        }
    }
}
