/**
 * Module containing all Java files
 * @author Ammar A
 * @author Nikhil G
 */
module com.gui.pizzamanagerproject4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gui.pizzamanagerproject4 to javafx.fxml;
    exports com.gui.pizzamanagerproject4;
}