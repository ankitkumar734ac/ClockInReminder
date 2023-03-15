package com.ca.main;

import com.ca.services.NetworkServices;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LogoutController {

    
    @FXML
    private Button logout;
        
    
    @FXML
    private void logoutButtonClicked(ActionEvent event) throws IOException {
        NetworkServices networkServices = new NetworkServices();
        networkServices.disableNetwork();
        networkServices = null;
        App.setRoot("login");
    }

}