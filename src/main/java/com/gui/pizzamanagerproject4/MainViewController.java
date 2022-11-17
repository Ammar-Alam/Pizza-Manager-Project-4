package com.gui.pizzamanagerproject4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for Main View
 * @author Ammar A
 * @author Nikhil G
 */
public class MainViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}