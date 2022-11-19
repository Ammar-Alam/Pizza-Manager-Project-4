package pizzaclasses;
/**
 * @author Ammar A
 * @author Nikhil G
 * Enum containing pizza sizes
 */
public enum Size {
    /**
     * Small
     */
    SMALL("Small"),
    /**
     * Medium
     */
    MEDIUM("Medium"),
    /**
     * Large
     */
    LARGE("Large");
    /**
     * Size of pizza
     */
    private final String size;

    /**
     * Constructor
     * @param size Size
     */
    Size(String size){
        this.size = size;
    }

    /**
     * Returns string form of size
     */
    public String getSize() {return this.size;}
}
