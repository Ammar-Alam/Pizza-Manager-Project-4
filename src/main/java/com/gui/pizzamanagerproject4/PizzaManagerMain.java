package com.gui.pizzamanagerproject4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pizzaclasses.StoreOrders;

import java.io.IOException;

/**
 * Class containing main method for app
 * @author Ammar A
 * @author Nikhil G
 */
public class PizzaManagerMain extends Application {
    /**
     * Store orders object
     */
    public static StoreOrders storeOrders = new StoreOrders();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaManagerMain.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("RU Pizza");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}