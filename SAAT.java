package apex;

/**
 * Represents the SAAT course, extending the abstract course class. Manages
 * operations for adding, deleting, and searching courses. Also handles discount
 * functionality for SAAT courses. By default, the SAAT course includes Biology,
 * Chemistry, Physics, and Mathematic.
 *
 * @author Amal
 */
import java.util.ArrayList;

public class SAAT extends course {

    private ArrayList<String> courses;
    public double PriceAfterDiscount = 0.0;
    public final double discountRates = 0.25;

    // Constructor: initializes the list of courses and adds some default courses
    public SAAT() {
        courses = new ArrayList<>();
        courses.add("Biology");
        courses.add("Chemistry");
        courses.add("Physics");
        courses.add("Mathematic");
    }

    /**
     * Applies a discount to the price if the code is correct.
     *
     * @param code Discount code (String)
     *
     * If the code equals "KSA", the discount will be applied to the price. If
     * the code is incorrect, a message will indicate //.
     */
    public void codeDiscount(String code) {
        if (code.equals("KSA")) {
            PriceAfterDiscount = super.discount(discountRates);

        } else {
            System.out.println("The code is invalid or expired.");
        }
    }

    /**
     * Adds a course to the list if it is within the allowed courses.
     *
     * @param course The name of the course to be added.
     */
    @Override
    public void addCourse(String course) {
        if (!(course.equalsIgnoreCase("Biology") || course.equalsIgnoreCase("Chemistry") || course.equalsIgnoreCase("Physics") || course.equals("Mathematic"))) {
            throw new ArithmeticException("not valid");
        } else {
            boolean add = false;
            for (int i = 0; i < courses.size(); i++) {
                add = courses.contains("Biology") && courses.contains("Chemistry") && courses.contains("Physics") && courses.contains("Mathematic");
            }

            if (add) {
                System.out.println("The course \"" + course + "\" already exists.");

            } else {

                courses.add(course);
                System.out.println("The course \"" + course + "\" has been added.");

            }

        }
    }

    /**
     * Deletes a course from the list.
     *
     * @param course Name of the course (String)
     *
     * If the course exists, it is removed and a message indicates this.
     */
    @Override
    public void deleteCourse(String course) {
        boolean removed = false;
        for (int i = 0; i < courses.size(); i++) {
            removed = course.equalsIgnoreCase(course);
        }

        if (removed) {
            courses.remove(course);
            System.out.println("The course \"" + course + "\" has been removed.");
        } else {
            System.out.println("The course \"" + course + "\" not found.");
        }
    }

    /**
     * Searches for a course in the list.
     *
     * @param courseName Name of the course to search for (String)
     *
     * If the course is found, a message indicates it is present. If not found,
     * a message indicates its absence.
     */
    @Override
    public void searchCourse(String courseName) {
        if (courses.contains(courseName)) {
            System.out.println("Course \"" + courseName + "\" found.");
        } else {
            System.out.println("Course \"" + courseName + "\" not found.");
        }
    }

    /**
     * Converts the SAAT object to a string.
     *
     * @return A string containing course information and its price after
     * discount (String)
     *
     * Displays course names and the price after applying the discount.
     */
    @Override
    public String toString() {
        String s = "";
        for (String course : courses) {
            s += course + " ";
        }
        if (PriceAfterDiscount != 0.0) {
            return "SAAT :\n" + super.toString() + " \nthe subjects are : " + s + " \nthe price of course after discount " + PriceAfterDiscount;
        } else {
            return "SAAT :\n" + super.toString() + "  \nthe subjects are : " + s;
        }
    }
}
