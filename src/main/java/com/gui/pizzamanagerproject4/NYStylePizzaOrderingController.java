package com.gui.pizzamanagerproject4;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * Controller For NY Style Pizza Ordering View
 * @author Ammar A
 * @author Nikhil G
 */
public class NYStylePizzaOrderingController {

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

}
