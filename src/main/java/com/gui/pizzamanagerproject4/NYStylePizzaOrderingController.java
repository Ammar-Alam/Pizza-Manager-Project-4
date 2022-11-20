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

    @FXML
    private ListView<String> availableToppings;

    @FXML
    private TextField crustTypeDisplay;

    @FXML
    private RadioButton largeCrust;

    @FXML
    private RadioButton medCrust;

    @FXML
    private ComboBox<String> pizzaFlavorSelection;

    @FXML
    private ListView<?> selectedToppings;

    @FXML
    private ToggleGroup size;

    @FXML
    private RadioButton smallCrust;

}
