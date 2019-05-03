/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myschool;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author gusta
 */
public class MySchool extends Application {
    public static Stage home;
    @Override
    public void start(Stage Home) throws IOException {
        this.home = Home;
        ShowHome();
    }
    public static void ShowHome() throws IOException{
        FXMLLoader Loader = new FXMLLoader();
	Loader.setLocation(MySchool.class.getResource("view/LoginView.fxml"));
	BorderPane bp = Loader.load();
        
        home.setTitle("Login");
        Scene scene = new Scene(bp);
        home.setScene(scene);
        home.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
