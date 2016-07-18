/*
*<>   APPLICATION: LoginSystem
*<>         CLASS: User
*<>        AUTHOR: Samuel Myles
*<>   JDK VERSION: 1.8.0_73
*<>   JRE VERSION: 1.8.0_73
*<>   APP PURPOSE: Prototype login system that supports a mock user database. Users are given the ability
*<>                to create a new account and login from that point forward.
*<> CLASS PURPOSE: Used as the main database entry class. Stores information about a new user that isn't
*<>                uniquely tied to that person such as an email and username.
*<>      INHERITS: Person
*<>                    Parent class that holds other identifying account information
*<>    IMPLEMENTS: Serializable
*<>                    Allows a binary database file to be created
*<>                Comparable
*<>                    Gives the database, which is a tree set structure, the ability to sort the User
*<>                    entries based on some criteria. In this application the database is sorted alphabetically
*<>                    by username
*<>       PACKAGE: model
*<>     PROFESSOR: Tanes Kanchanawanchai [CSC 202-061N]
*/

package model;


import java.io.Serializable;
import java.util.Comparator;

public class User extends Person implements Serializable, Comparable<User>{
    private String username;
    private String password;
    private String email;
    private String phone;
    private String photo;

    // Although multiple constructors can be created to handle when different combinations
    // of fields are filled out, all that's needed is this one constructor that only takes
    // the required fields. If optional fields were filled out, use the setter methods to
    // fill in that information
    public User(String fName, String lName, String gen, String dob,
                String uName, String pass)
    {
        super(fName, lName, gen, dob);

        this.username = uName;
        this.password = pass;
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String newUserName){ this.username = newUserName; }

    public String getPassword() { return this.password; }
    public void setPassword(String newPassword) { this.password = newPassword; }

    public String getEmail() { return this.email; }
    public void setEmail(String newEmail) { this.email = newEmail; }

    public String getPhoneNumber() { return this.phone; }
    public void setNewPhoneNumber(String newPhoneNumber) { this.phone = newPhoneNumber; }

    public String getPhotoPath() { return this.photo; }
    public void setPhotoPath(String newPath) { this.photo = newPath; }

    @Override
    public String toString(){
        return (super.toString() +
                "[Username: " + this.username + "] " +
                "[Email: " + this.email + "] " +
                "[Photo Path: " + this.photo + "]");
    }

    // Used by certain data structures such as sets and ordered lists to
    // order the Users by their username
    @Override
    public int compareTo(User otherUser) {
        // Use this class userSorter to compare with another user
        // using chain comparators
        return userSorter.compare(this, otherUser);
    }

    public boolean equals(User otherUser){
        return username.compareTo(otherUser.getUsername());
    }
}
