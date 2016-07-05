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
                " Username: " + this.username + "\n" +
                " Email: " + this.email + "\n" +
                " Photo Path: " + this.photo + "\n\n");
    }

    // This method is used by the TreeSet UserStorage.userDatabase to test
    // if a certain element or field is already present in the set.
    // Here I'm overriding it so that UserStorage.userDatabase checks if a
    // provided Object (which will be an input String) has a username that
    // is equal to this User
    @Override
    public int compareTo(User otherUser) {
        // Uses the String class .compareTo method to check
        // if this User username matches a given String. Another
        // User object's username will be the input String
        return username.compareTo(otherUser.getUsername());
    }
}
