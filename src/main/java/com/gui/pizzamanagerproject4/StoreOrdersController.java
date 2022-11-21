package com.gui.pizzamanagerproject4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pizzaclasses.Order;
import pizzaclasses.Pizza;
import pizzaclasses.StoreOrders;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * Controller for Store Orders View
 * @author Ammar A
 * @author Nikhil G
 */
public class StoreOrdersController implements Initializable {

    /**
     * Store orders
     */
    private StoreOrders storeOrders= new StoreOrders();
    /**
     * Cancel order button
     */
    @FXML
    private Button cancelOrderButton;

    /**
     * Export orders button
     */
    @FXML
    private Button exportOrdersButton;

    /**
     * Order number selection
     */
    @FXML
    private ComboBox<Order> orderNumberSelection;

    /**
     * Order total value
     */
    @FXML
    private TextField orderTotalText;

    /**
     * View pizzas
     */
    @FXML
    private ListView<Pizza> pizzaDisplayList;

    /**
     * Cancel selected order
     * @param event Triggering event
     */
    @FXML
    void cancelOrder(ActionEvent event) {
        if(orderNumberSelection.getSelectionModel().isEmpty()) return;
        storeOrders.remove(orderNumberSelection.getSelectionModel().getSelectedItem());
        updateStoreOrders();
        Stage stage = (Stage) cancelOrderButton.getScene().getWindow();
        stage.close();
    }
    /**
     * Export orders
     * @param event Triggering event
     */
    @FXML
    void exportOrders(ActionEvent event) {
        storeOrders.export();
    }
    @FXML
    void changeList(ActionEvent event){
        if(orderNumberSelection.getSelectionModel().isEmpty()) return;
        pizzaDisplayList.getItems().clear();
        pizzaDisplayList.getItems().addAll(orderNumberSelection.getSelectionModel().getSelectedItem().getOrderItems());
        DecimalFormat df = new DecimalFormat("#.##");
        orderTotalText.setText(String.valueOf((df.format((orderNumberSelection.getSelectionModel().getSelectedItem().getTax()+orderNumberSelection.getSelectionModel().getSelectedItem().getSubtotal())))));
    }
    /**
     * Initialize
     * @param url Url
     * @param resourceBundle Resource Bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getStoreOrders();
        for(Order order : storeOrders.getOrders()){
            orderNumberSelection.getItems().add(order);
        }
    }

    /**
     * Gets store orders from main controller
     */
    void getStoreOrders(){
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaManagerMain.class.getResource("MainView.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainViewController mainViewController = fxmlLoader.getController();
        storeOrders = mainViewController.passStoreOrder();
    }

    /**
     * Send updated store orders to main controller
     */
    void updateStoreOrders(){
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaManagerMain.class.getResource("MainView.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.getStoreOrder(storeOrders);
    }
}
