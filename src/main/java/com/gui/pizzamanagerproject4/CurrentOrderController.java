package com.gui.pizzamanagerproject4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pizzaclasses.Order;
import pizzaclasses.Pizza;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller For Current Order View
 * @author Ammar A
 * @author Nikhil G
 */
public class CurrentOrderController implements Initializable {

    /**
     * Clear Order Button
     */
    @FXML
    private Button clearOrderButton;

    /**
     * Pizzas list view
     */
    @FXML
    private ListView<Pizza> orderListView;

    /**
     * Display order number
     */
    @FXML
    private TextField orderNumberDisplay;

    /**
     * Place order button
     */
    @FXML
    private Button placeOrderButton;

    /**
     * Remove selected pizza button
     */
    @FXML
    private Button removeSelectedPizzaButton;

    /**
     * Subtotal text
     */
    @FXML
    private TextField subtotalBox;

    /**
     * Tax text
     */
    @FXML
    private TextField taxBox;

    /**
     * Total text
     */
    @FXML
    private TextField totalBox;
    /**
     * Current Order
     */
    private static Order order;

    /**
     * Clears all items from order
     * @param event Triggering event
     */
    @FXML
    void clearOrder(ActionEvent event) {
        order.clearOrder();
        updateOrder();
        updateList();
        Stage stage = (Stage) clearOrderButton.getScene().getWindow();
        stage.close();
    }

    /**
     *
     * @param event Triggering event
     */
    @FXML
    void placeOrder(ActionEvent event) {
        if(orderListView.getItems().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Order");
            alert.setContentText("You cannot place an order without adding a pizza first!");
            alert.showAndWait();
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.submitOrder();
        Stage stage = (Stage) placeOrderButton.getScene().getWindow();
        stage.close();
    }

    /**
     *
     * @param event Triggering event
     */
    @FXML
    void removePizza(ActionEvent event) {
        if(orderListView.getSelectionModel().isEmpty()) return;
        order.remove(orderListView.getSelectionModel().getSelectedItem());
        orderListView.getItems().remove(orderListView.getSelectionModel().getSelectedItem());
        subtotalBox.clear();
        taxBox.clear();
        totalBox.clear();
        updateList();
        updateOrder();
    }

    /**
     * Initialization method for setting contents of all displays related to order
     * @param url URL
     * @param resourceBundle Resource Bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getOrder();
        updateList();
    }

    /**
     * Get reference to current order
     * @param order Order to send to this controller
     */
    public void getOrder(Order order){
        this.order = order;
    }

    /**
     * Updates order number, subtotal, tax, and total
     */
    void updateValues(){
        order.calculate();
        orderNumberDisplay.setText(String.valueOf(order.getOrderNum()));
        DecimalFormat df = new DecimalFormat("#.##");
        subtotalBox.setText(df.format(order.getSubtotal()));
        taxBox.setText(df.format(order.getTax()));
        totalBox.setText(df.format((order.getSubtotal()+order.getTax())));
    }

    /**
     * Updates list view with new values
     */
    void updateList(){
        orderListView.getItems().removeAll();
        ArrayList<Pizza> orderedPizzas = order.getOrderItems();
        for(Pizza pizza : orderedPizzas){
            if(!orderedPizzas.isEmpty()){
                orderListView.getItems().add(pizza);
            }
        }
        updateValues();
    }

    /**
     * Gets order from main controller
     */
    void getOrder(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainViewController mainViewController = fxmlLoader.getController();
        order = mainViewController.passOrder();
    }

    /**
     * Sends modified order to main controller
     */
    void updateOrder(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.getOrder(order);
    }
}
