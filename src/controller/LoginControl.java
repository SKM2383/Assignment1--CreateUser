/*
*<>   APPLICATION: LoginSystem
*<>         CLASS: LoginControl
*<>        AUTHOR: Samuel Myles
*<>   JDK VERSION: 1.8.0_73
*<>   JRE VERSION: 1.8.0_73
*<>   APP PURPOSE: Prototype login system that supports a mock user database. Users are given the ability
*<>                to create a new account and login from that point forward.
*<> CLASS PURPOSE: Authenticates any attempts that are made to log in from the login.fxml screen. It does
*<>                this by iterating through the database of currently registered Users and checks their
*<>                usernames and passwords against those provided at the login screen.
*<>       PACKAGE: controller
*<>     PROFESSOR: Tanes Kanchanawanchai [CSC 202-061N]
*/

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javafx.event.Event;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import model.UserStorage;
import model.User;
import view.SignUpView;

public class LoginControl {
    @FXML
    private TextField txtfldUsername;
    @FXML
    private PasswordField psfPassword;
    @FXML
    private Label lblSignInStatus;

    // Private helper method to check if a TextField or a subclass [PasswordField]
    // is null or empty.
    private boolean fieldIsEmpty(TextField textField){
        if(textField.getText() == null || textField.getText().trim().isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    @FXML
    public void authenticate(Event e){
        TreeSet<User> userDatabase = UserStorage.getUserDatabase();

        // Make sure that the username and password fields are not empty
        if(!fieldIsEmpty(txtfldUsername) && !fieldIsEmpty(psfPassword)){

            // If the fields are filled out then extract their text
            String signInUsername = txtfldUsername.getText();
            String signInPassword = psfPassword.getText();

            // Now iterate through the database and check each database user's username and password
            Iterator<User> databaseIterator = userDatabase.iterator();
            while(databaseIterator.hasNext()){
                User nextUser = databaseIterator.next();

                // If the provided username and password matches, show the successful login message
                if(nextUser.getUsername().equals(signInUsername) && nextUser.getPassword().equals(signInPassword)){
                    lblSignInStatus.setText("Sign In Successful");
                    lblSignInStatus.setVisible(true);
                }
                // Else if the database contains more Users, then just continue without showing a login error
                // since there are more Users to be checked
                else if(databaseIterator.hasNext()){
                    continue;
                }
                // At this point all database users have been checked, which means the credentials didn't match
                // any database user, so show the login error
                else{
                    lblSignInStatus.setText("Incorrect Username or Password");
                    lblSignInStatus.setVisible(true);
                }
            }
        }
        else{
            lblSignInStatus.setText("Fill in the username and password");
            lblSignInStatus.setVisible(true);
        }
    }

    @FXML
    public void showSignupView(Event e) throws IOException{
        SignUpView signupView = new SignUpView();
        Stage previousStage = (Stage) txtfldUsername.getScene().getWindow();
        previousStage.close();
    }
}
