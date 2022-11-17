package pizzaclasses;

/**
 * @author Ammar A
 * @author Mikhil G
 */
public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}