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

import javafx.event.Event;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import model.UserStorage;
import model.User;

import util.list.ArrayOrderedList;

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
        ArrayOrderedList<User> userDatabase = UserStorage.getUserDatabase();

        // Make sure that the username and password fields are not empty
        if(!fieldIsEmpty(txtfldUsername) && !fieldIsEmpty(psfPassword)){

            // If the fields are filled out then extract their text
            String signInUsername = txtfldUsername.getText();
            String signInPassword = psfPassword.getText();

            lblSignInStatus.setVisible(false);

            // Now extract each database user and compare their username and password
            userDatabase.reset();
            User nextUser;

            while(userDatabase.hasNext()){
                nextUser = userDatabase.getNext();
                System.out.println(nextUser);

                /* If the nextUser is equal to null, that means the database hasn't been created yet, so
                   show the login error prompt */
                if(nextUser == null){
                    lblSignInStatus.setText("No users in the database");
                    lblSignInStatus.setVisible(true);
                    break;
                }
                else if(nextUser.getUsername().equals(signInUsername) && nextUser.getPassword().equals(signInPassword))
                {
                    lblSignInStatus.setText("Sign In Successful");
                    lblSignInStatus.setVisible(true);
                    break;
                }
                else{
                    // If there aren't any more Users to check, that means the record wasn't found, so
                    // show login error
                    if(!userDatabase.hasNext()){
                        lblSignInStatus.setText("Incorrect Username or Password");
                        lblSignInStatus.setVisible(true);
                    }
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
