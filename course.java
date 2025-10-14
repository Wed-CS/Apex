package apex;

/**
 * Abstract class representing a course in the Apex platform.
 *
 * @author Mashael Shaker
 */
public abstract class course implements discountInterface {

    public final double price = 550;

    public course() {

    }

    public abstract void addCourse(String course);

    public abstract void deleteCourse(String course);

    public abstract void searchCourse(String courseName);

    /**
     *
     * @param percentage take the price of course before discount
     * @return price of course after discount
     */
    @Override
    public double discount(double percentage) {

        return (price - (percentage * price));
    }

    @Override
    public String toString() {
        return "the price of course = " + price;
    }
}
