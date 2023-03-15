package com.ca.main;

import com.ca.services.NetworkServices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

/**
 * JavaFX App
 *
 * @author Ankit Kumar
 * To execute mvn clean javafx:run
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void init() throws Exception {
        super.init();
        NetworkServices networkServices = new NetworkServices();
        networkServices.disableNetwork();
        //networkServices.closeCommandPrompt();
        networkServices = null;
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("Stage is closing");
                //launch();
                 stage.setIconified(true);
                 launch();
            }
        });

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
        //super.stop(); 
        System.out.println("com.ca.main.App.stop()");
    }

}
