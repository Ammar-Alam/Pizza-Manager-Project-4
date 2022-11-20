package com.gui.pizzamanagerproject4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller for Main View
 * @author Ammar A
 * @author Nikhil G
 */
public class MainViewController {

    /**
     * Button to order Chicago style pizza
     */
    @FXML
    private Button orderChicagoStyle;

    /**
     * Button to order New York style pizza
     */
    @FXML
    private Button orderNYStyle;

    /**
     * Button to see your current order
     */
    @FXML
    private Button showOrderButton;

    /**
     * Button to see store orders
     */
    @FXML
    private Button storeOrdersButton;

    /**
     * Starts process to order a Chicago style pizza
     * @param event Triggering event
     */
    @FXML
    void orderChicagoPizza(ActionEvent event) {
    }

    /**
     * Starts process to order a New York style pizza
     * @param event Triggering event
     */
    @FXML
    void orderNYPizza(ActionEvent event) {
    }

    /**
     * Starts process to view and edit your current order
     * @param event Triggering event
     */
    @FXML
    void viewOrder(ActionEvent event) {
    }

    /**
     * Starts process to view the current store orders
     * @param event Triggering event
     */
    @FXML
    void viewStoreOrders(ActionEvent event) {
    }

}
