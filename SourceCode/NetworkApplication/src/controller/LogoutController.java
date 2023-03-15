package controller;

import services.NetworkServices;
import java.io.IOException;
import main.App;
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