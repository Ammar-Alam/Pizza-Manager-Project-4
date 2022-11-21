/**
 * Module containing all Java files
 * @author Ammar A
 * @author Nikhil G
 */
module com.gui.pizzamanagerproject4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.gui.pizzamanagerproject4 to javafx.fxml;
    exports com.gui.pizzamanagerproject4;
}