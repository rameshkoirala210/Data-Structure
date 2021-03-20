/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps.salary;

/**
 * User class 
 * Each user is uniquely identified by his id, name, 
 * and email
 * @author ITSC 2214
 * @version 1.0
 */
public class User {
    private long id;
    private String name;
    private String email;
    
    /** 
     * Default constructor
     */
    private User() {
    }

    /**
     * Constructor
     * @param aID id 
     * @param aName name
     * @param anEmail email
     */
    public User(long aID, String aName, String anEmail) {
        this.id = aID;
        this.name = aName;
        this.email = anEmail;
    }
            
    /**
     * Retrieve user ID
     * @return id 
     */
    public long getID() {
        return this.id;
    }
    
    /**
     * Retrieve user name
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Retrieve user email
     * @return email
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     * Change user name 
     * @param anotherName another name
     */
    public void setName(String anotherName) {
        this.name = anotherName;
    }
    
    /**
     * Change user email 
     * @param anotherEmail another email
     */   
    public void setEmail(String anotherEmail) {
        this.email = anotherEmail;
    }
    
    /**
     * TODO
     * Examine whether this object itself is equal to
     * given object
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        User user = (User) o;
        
        //TODO return true if all these three variable values
        // are same between the object itself and the given
        // object
        return id == user.getID()
                && (name.equals(user.getName()) 
                && email.equals(user.getEmail()));
    }
    
    /**
     * Hashing function
     * The function overrides the builtin hashCode method 
     * of the Object class, which returns the integer hashed 
     * value. If two or more objects are equal according
     * to the equals method, then their hashes should be 
     * equal too. If two or more objects are not equal 
     * according to the equals method, then their hashes 
     * can be equal or unequal.
     * It includes all fields of the User class so that it 
     * can produce different results for unequal objects:
     * @return 
     */
    @Override
    public int hashCode() {
        return (int) id * name.hashCode() * email.hashCode();
    }
    
    /**
     * 
     * @return text representation of a user
     */
    @Override
    public String toString() {
        return "ID:" + id + " name = "
                + name + " email = " + email + "\n";
    }
}
