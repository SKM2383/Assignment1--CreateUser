/*
*<>   APPLICATION: LoginSystem
*<>         CLASS: UserStorage
*<>        AUTHOR: Samuel Myles
*<>   JDK VERSION: 1.8.0_73
*<>   JRE VERSION: 1.8.0_73
*<>   APP PURPOSE: Prototype login system that supports a mock user database. Users are given the ability
*<>                to create a new account and login from that point forward.
*<> CLASS PURPOSE: This class is used to act as the database when it is loaded into the program. The
*<>                actual database is a tree structure of Users that is sorted by username.
*<>       PACKAGE: model
*<>     PROFESSOR: Tanes Kanchanawanchai [CSC 202-061N]
*/

package model;

import java.util.Comparator;
import java.util.TreeSet;

public class UserStorage {
    private static TreeSet<User> userDatabase = new TreeSet<>();

    public static TreeSet<User> getUserDatabase() {
        return userDatabase;
    }

    public static void setUserDatabase(TreeSet<User> newUserDatabase) {
        userDatabase = newUserDatabase;
    }
}
