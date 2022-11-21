package com.gui.pizzamanagerproject4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pizzaclasses.Order;
import pizzaclasses.Pizza;
import pizzaclasses.StoreOrders;

/**
 * Controller for Main View
 * @author Ammar A
 * @author Nikhil G
 */
public class MainViewController {

    /**
     * Store orders variable
     */
    private static StoreOrders storeOrders = new StoreOrders();
    /**
     * Current order variable
     */
    private static Order myOrder = new Order(storeOrders.getNextOrderNumber());

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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ChicagoStylePizzaOrderingView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order A Chicago Pizza");
            stage.setResizable(false);
            stage.setScene(new Scene(root1, 600, 400));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            return;
        }
    }

    /**
     * Starts process to order a New York style pizza
     * @param event Triggering event
     */
    @FXML
    void orderNYPizza(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("NYStylePizzaOrderingView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order A New York Pizza");
            stage.setResizable(false);
            stage.setScene(new Scene(root1, 600, 400));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            return;
        }
    }

    /**
     * Starts process to view and edit your current order
     * @param event Triggering event
     */
    @FXML
    void viewOrder(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CurrentOrderView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setResizable(false);
            stage.setScene(new Scene(root1, 600, 400));
            stage.initModality(Modality.APPLICATION_MODAL);
            CurrentOrderController orderController = fxmlLoader.getController();
            orderController.getOrder(myOrder);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            return;
        }
    }

    /**
     * Starts process to view the current store orders
     * @param event Triggering event
     */
    @FXML
    void viewStoreOrders(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("StoreOrdersView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setResizable(false);
            stage.setScene(new Scene(root1, 600, 400));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
            return;
        }
    }

    /**
     * Adds a pizza to the current order
     * @param pizza Pizza to add
     */
    void addToOrder(Pizza pizza){
        myOrder.add(pizza);
    }

    /**
     * Adds myOrder to the store orders and resets myOrder
     */
    void submitOrder(){
        storeOrders.add(myOrder);
        myOrder = new Order(storeOrders.getNextOrderNumber());
    }

    /**
     * Receives edited order
     * @param newOrder Edited order
     */
    void getOrder(Order newOrder){
        myOrder = newOrder;
    }

    /**
     * Receives edited store order
     * @param newOrder Edited store order
     */
    void getStoreOrder(StoreOrders newOrder){
        storeOrders = newOrder;
    }

    /**
     * Passes myOrder
     * @return myOrder
     */
    public Order passOrder(){
        return myOrder;
    }
    /**
     * Passes storeOrders
     * @return storeOrders
     */
    public StoreOrders passStoreOrder(){
        return storeOrders;
    }

}
