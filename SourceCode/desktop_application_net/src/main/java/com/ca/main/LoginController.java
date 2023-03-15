package com.ca.main;

import com.ca.services.DataServices;
import com.ca.services.NetworkServices;
import java.io.IOException;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class LoginController {

    @FXML
    private Button login;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private Label error;
    @FXML
    private Label emailError;
    @FXML
    private Label passwordError;

    @FXML
    private void clickedLoginButton(ActionEvent event) throws IOException {
        System.out.println(email.getText());
        System.out.println(password.getText());
        error.setVisible(false);
        Properties props = DataServices.readPropertiesFile();

        String emailTxt = email.getText();
        String passwordTxt = password.getText();

        if (emailTxt.isEmpty() && passwordTxt.isEmpty()) {
            emailError.setVisible(true);
            passwordError.setVisible(true);
        } else if (emailTxt.isEmpty()) {
            emailError.setVisible(true);
        } else if (passwordTxt.isEmpty()) {
            passwordError.setVisible(true);
        } else if (props.get(emailTxt) != null && props.get(emailTxt).equals(passwordTxt)) {
            NetworkServices networkServices = new NetworkServices();
            networkServices.enableNetwork();
            networkServices = null;
            App.setRoot("logout");
        } else {
            error.setVisible(true);
            error.setText("Email or Password is Invalid!");
        }

    }

    @FXML
    private void onEmailTyped(KeyEvent event) {
        error.setVisible(false);
        emailError.setVisible(false);
    }

    @FXML
    private void onPasswordTyped(KeyEvent event) {
        error.setVisible(false);
        passwordError.setVisible(false);
    }

   
}
