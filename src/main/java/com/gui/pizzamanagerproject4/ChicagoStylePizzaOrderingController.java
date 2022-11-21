package com.gui.pizzamanagerproject4;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import pizzaclasses.*;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * Controller for the Chicago Style Pizza Ordering View
 * @author Ammar A
 * @author Nikhil G
 */
public class ChicagoStylePizzaOrderingController implements Initializable {

    /**
     * Maximum number of toppings any pizza can have
     */
    private static final int MAX_TOPPINGS = 7;
    /**
     * List of all available toppings
     */
    private static final String[] allToppings = {
            Topping.SAUSAGE.getTopping(),
            Topping.PEPPERONI.getTopping(),
            Topping.GREEN_PEPPER.getTopping(),
            Topping.ONION.getTopping(),
            Topping.MUSHROOM.getTopping(),
            Topping.BBQ_CHICKEN.getTopping(),
            Topping.PROVOLONE.getTopping(),
            Topping.CHEDDAR.getTopping(),
            Topping.BEEF.getTopping(),
            Topping.HAM.getTopping()
    };
    /**
     * Pizza factory
     */
    private ChicagoPizza pizzaFactory = new ChicagoPizza();
    /**
     * Listview displaying toppings available to add
     */
    @FXML
    private ListView<String> availableToppings;
    /**
     * Textfield displaying crust type
     */
    @FXML
    private TextField crustTypeDisplay;
    /**
     * Large crust button
     */
    @FXML
    private RadioButton largeCrust;
    /**
     * Medium crust button
     */
    @FXML
    private RadioButton medCrust;
    /**
     * Combobox for selecting pizza flavors
     */
    @FXML
    private ComboBox<String> pizzaFlavorSelection;
    /**
     * Listview displaying selected toppings
     */
    @FXML
    private ListView<String> selectedToppings;
    /**
     * Pizza crust size toggle group
     */
    @FXML
    private ToggleGroup size;
    /**
     * Small crust button
     */
    @FXML
    private RadioButton smallCrust;
    /**
     * Button to add a selected topping
     */
    @FXML
    private Button addToppingButton;
    /**
     * Button to remove a selected topping
     */
    @FXML
    private Button removeToppingButton;
    /**
     * Button to add current pizza to order
     */
    @FXML
    private Button addToOrderButton;
    /**
     * Area to display price of current pizza
     */
    @FXML
    private TextField priceBox;
    /**
     * Pizza being made
     */
    private Pizza pizza;
    /**
     * Initialization method for setting contents of all options to a small build your own pizza with no toppings
     * @param url URL
     * @param resourceBundle Resource Bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pizzaFlavorSelection.setItems(FXCollections.observableArrayList("Build your own", "BBQ Chicken", "Meatzza", "Deluxe"));
        pizzaFlavorSelection.getSelectionModel().selectFirst();
        availableToppings.getItems().addAll(allToppings);
        crustTypeDisplay.setText(Crust.PAN.getCrustType());
        availableToppings.setDisable(false);
        selectedToppings.setDisable(false);
        addToppingButton.setDisable(false);
        removeToppingButton.setDisable(false);
        updatePizza();
    }

    /**
     * Adds the selected topping if allowed
     * @param event Triggering event
     */
    @FXML
    void addTopping(ActionEvent event) {
        // Check if Build Your Own Pizza is the selected flavor
        if(pizzaFlavorSelection.getSelectionModel().isEmpty()) return;
        if(!pizzaFlavorSelection.getSelectionModel().getSelectedItem().equals("Build your own")) return;
        if((selectedToppings.getItems().isEmpty() || selectedToppings.getItems().size()< MAX_TOPPINGS) && availableToppings.getSelectionModel().getSelectedItem() != null){
            selectedToppings.getItems().add(availableToppings.getSelectionModel().getSelectedItem());
            availableToppings.getItems().remove(availableToppings.getSelectionModel().getSelectedItem());
            updatePizza();
        }
        if(selectedToppings.getItems().size() >= MAX_TOPPINGS){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Maximum Toppings Reached");
            alert.setContentText("You cannot add more than 7 toppings to a custom pizza!");
            alert.showAndWait();
        }


    }

    /**
     * Removes the selected topping
     * @param event Triggering event
     */
    @FXML
    void removeTopping(ActionEvent event) {
        // Check if Build Your Own Pizza is the selected flavor
        if(pizzaFlavorSelection.getSelectionModel().isEmpty()) return;
        if(!pizzaFlavorSelection.getSelectionModel().getSelectedItem().equals("Build your own")) return;
        if(selectedToppings.getItems().isEmpty()) return; // Check if no toppings are selected
        if(selectedToppings.getSelectionModel().getSelectedItem() != null) {
            availableToppings.getItems().add(selectedToppings.getSelectionModel().getSelectedItem());
            selectedToppings.getItems().remove(selectedToppings.getSelectionModel().getSelectedItem());
            updatePizza();
        }
    }

    /**
     * Updates topping and crust selections based on selected flavor
     * @param event Triggering event
     */
    @FXML
    void updateFlavor(ActionEvent event){
        if(pizzaFlavorSelection.getSelectionModel().isEmpty()) return;
        resetToppings();
        switch (pizzaFlavorSelection.getSelectionModel().getSelectedItem()){
            case "Build your own" -> {
                availableToppings.setDisable(false);
                selectedToppings.setDisable(false);
                addToppingButton.setDisable(false);
                removeToppingButton.setDisable(false);
                crustTypeDisplay.setText(Crust.PAN.getCrustType());
                resetToppings();
            }
            case "BBQ Chicken" -> setBBQChicken();
            case "Meatzza" -> setMeatzza();
            case "Deluxe" -> setDeluxe();
        }
        updatePizza();
    }

    /**
     * Sets options for a BBQ chicken pizza
     */
    @FXML
    void setBBQChicken(){
        crustTypeDisplay.setText(Crust.THIN.getCrustType()); // set crust
        //set toppings
        selectedToppings.getItems().add(Topping.BBQ_CHICKEN.getTopping());
        selectedToppings.getItems().add(Topping.GREEN_PEPPER.getTopping());
        selectedToppings.getItems().add(Topping.PROVOLONE.getTopping());
        selectedToppings.getItems().add(Topping.CHEDDAR.getTopping());

        availableToppings.getItems().remove(Topping.BBQ_CHICKEN.getTopping());
        availableToppings.getItems().remove(Topping.GREEN_PEPPER.getTopping());
        availableToppings.getItems().remove(Topping.PROVOLONE.getTopping());
        availableToppings.getItems().remove(Topping.CHEDDAR.getTopping());
        availableToppings.setDisable(true);

        selectedToppings.setDisable(true);
        addToppingButton.setDisable(true);
        removeToppingButton.setDisable(true);
    }
    /**
     * Sets options for a Meatzza pizza
     */
    @FXML
    void setMeatzza(){
        crustTypeDisplay.setText(Crust.HAND_TOSSED.getCrustType()); // set crust
        //set toppings
        selectedToppings.getItems().add(Topping.SAUSAGE.getTopping());
        selectedToppings.getItems().add(Topping.PEPPERONI.getTopping());
        selectedToppings.getItems().add(Topping.BEEF.getTopping());
        selectedToppings.getItems().add(Topping.HAM.getTopping());

        availableToppings.getItems().remove(Topping.SAUSAGE.getTopping());
        availableToppings.getItems().remove(Topping.PEPPERONI.getTopping());
        availableToppings.getItems().remove(Topping.BEEF.getTopping());
        availableToppings.getItems().remove(Topping.HAM.getTopping());

        availableToppings.setDisable(true);
        selectedToppings.setDisable(true);
        addToppingButton.setDisable(true);
        removeToppingButton.setDisable(true);
    }
    /**
     * Sets options for a Deluxe pizza
     */
    @FXML
    void setDeluxe(){
        crustTypeDisplay.setText(Crust.BROOKLYN.getCrustType()); // set crust
        //set toppings
        selectedToppings.getItems().add(Topping.SAUSAGE.getTopping());
        selectedToppings.getItems().add(Topping.PEPPERONI.getTopping());
        selectedToppings.getItems().add(Topping.GREEN_PEPPER.getTopping());
        selectedToppings.getItems().add(Topping.ONION.getTopping());
        selectedToppings.getItems().add(Topping.MUSHROOM.getTopping());

        availableToppings.getItems().remove(Topping.SAUSAGE.getTopping());
        availableToppings.getItems().remove(Topping.PEPPERONI.getTopping());
        availableToppings.getItems().remove(Topping.GREEN_PEPPER.getTopping());
        availableToppings.getItems().remove(Topping.ONION.getTopping());
        availableToppings.getItems().remove(Topping.MUSHROOM.getTopping());

        availableToppings.setDisable(true);
        selectedToppings.setDisable(true);
        addToppingButton.setDisable(true);
        removeToppingButton.setDisable(true);
    }

    /**
     * Resets topping selection
     */
    @FXML
    void resetToppings(){
        selectedToppings.getItems().clear();
        availableToppings.getItems().clear();
        availableToppings.getItems().addAll(allToppings);
    }

    /**
     * Updates pizza whenever size is changed
     * @param event Triggering event
     */
    @FXML
    void sizeChanged(ActionEvent event){
        updatePizza();
    }

    /**
     * Submit current pizza to order
     * @param event Triggering event
     */
    @FXML
    void addToOrder(ActionEvent event) {
        updatePizza();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Added To Order");
        alert.setContentText("Your pizza has been added to your current order!");
        alert.showAndWait();
        FXMLLoader fxmlLoader = new FXMLLoader(PizzaManagerMain.class.getResource("MainView.fxml"));
        try {
            Parent root = (Parent) fxmlLoader.load();
            MainViewController controller = fxmlLoader.getController();
            controller.addToOrder(pizza);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts Crust value from string
     * @param input Input string
     * @return Crust enum value
     */
    Crust extractCrust(String input){
        switch (input){
            case "Deep Dish" -> {
                return Crust.DEEP_DISH;
            }
            case "Pan" -> {
                return Crust.PAN;
            }
            case "Stuffed" -> {
                return Crust.STUFFED;
            }
            case "Brooklyn" -> {
                return Crust.BROOKLYN;
            }
            case "Thin" -> {
                return Crust.THIN;
            }
            case "Hand Tossed" -> {
                return Crust.HAND_TOSSED;
            }
            default -> {
                return null;
            }
        }
    }
    /**
     * Extracts Topping value from string
     * @param input Input string
     * @return Topping enum value
     */
    Topping extractTopping(String input){
        switch (input){
            case "Sausage" -> {
                return Topping.SAUSAGE;
            }
            case "Pepperoni" -> {
                return Topping.PEPPERONI;
            }
            case "Green Pepper" -> {
                return Topping.GREEN_PEPPER;
            }
            case "Onion" -> {
                return Topping.ONION;
            }
            case "BBQ Chicken" -> {
                return Topping.BBQ_CHICKEN;
            }
            case "Provolone" -> {
                return Topping.PROVOLONE;
            }
            case "Cheddar" -> {
                return Topping.CHEDDAR;
            }
            case "Beef" -> {
                return Topping.BEEF;
            }
            case "Ham" -> {
                return Topping.HAM;
            }
            default -> {
                return null;
            }
        }
    }

    /**
     * Determines size of pizza selected
     * @return Size of pizza
     */
    Size findSize(){
        if(smallCrust.isSelected()) return Size.SMALL;
        if(medCrust.isSelected()) return Size.MEDIUM;
        if(largeCrust.isSelected()) return Size.LARGE;
        return null;
    }

    /**
     * Updates Pizza object to the current selections and updates the price
     */
    @FXML
    void updatePizza() {
        Size pizzaSize = findSize();
        Crust pizzaCrust = extractCrust(crustTypeDisplay.getText());
        Double price = 0.0;
        switch (pizzaFlavorSelection.getSelectionModel().getSelectedItem()){
            case "Build your own" -> {
                pizza = pizzaFactory.createBuildYourOwn();
                pizza.setSize(pizzaSize);
                for(String topping : selectedToppings.getItems()){
                    pizza.add(extractTopping(topping));
                }
                price = pizza.price();
            }
            case "BBQ Chicken" -> {
                pizza = pizzaFactory.createBBQChicken();
                pizza.setSize(pizzaSize);
                price = pizza.price();
            }
            case "Meatzza" -> {
                pizza = pizzaFactory.createMeatzza();
                pizza.setSize(pizzaSize);
                price = pizza.price();
            }
            case "Deluxe" -> {
                pizza = pizzaFactory.createDeluxe();
                pizza.setSize(pizzaSize);
                price = pizza.price();
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        priceBox.setText(df.format(price).toString());
    }
}
