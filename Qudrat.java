package apex;

/**
 * Represents a Qudrat course, extending the abstract course class. Manages
 * course operations like adding, deleting, searching for courses, and applying
 * discounts based on provided codes. By default, the Qudrat course includes
 * "math" and "arabic".
 *
 * @author Esraa AbdElraheem
 */
import java.util.ArrayList;

public class Qudrat extends course {

    private ArrayList<String> courses = new ArrayList<>();

    public double PriceAfterDiscount = 0.0;
    private final double discountRates = .15;

    /**
     * Constructor that adds default courses to the list (math and arabic).
     */
    public Qudrat() {
        courses.add(("math"));
        courses.add(("arabic"));
    }

    /**
     * Gets the list of courses.
     *
     * @return the list of courses.
     */
    public ArrayList<String> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses
     *
     * @param courses The new list of courses.
     */
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    /**
     * Applies a discount to the course if the discount code is "KSA".
     * Otherwise, it prints that the code is invalid.
     *
     * @param code The discount code to apply.
     */
    public void codeDiscount(String code) {
        if (code.equals("KSA")) {
            PriceAfterDiscount = super.discount(discountRates);

        } else {
            System.out.println("The code is invalid or expired.");
        }
    }

    /**
     * Adds a new course to the list if the course is allowed. If the course
     * already exists, it prints a message.
     *
     * @param course The course to be added.
     */
    @Override
    public void addCourse(String course) {
        if (!(course.equalsIgnoreCase("math") || course.equalsIgnoreCase("arabic"))) {
            throw new ArithmeticException("not valid");
        } else {
            boolean add = false;
            for (int i = 0; i < courses.size(); i++) {
                add = courses.contains("math") && courses.contains("arabic");
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
     * Deletes a course from the list if it exists.
     *
     * @param course The course to be deleted.
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
     * Searches for a course in the list. Prints whether the course was found or
     * not.
     *
     * @param courseName The name of the course to search for.
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
     * Returns a string representation of the Qudrat class. Includes the list of
     * courses and the price after discount (if applied)
     *
     * @return a string that describes the Qudrat object.
     */
    public String toString() {

        String s = "";
        for (String course : courses) {
            s += course + " ";
        }
        if (PriceAfterDiscount != 0.0) {
            return "Qudrat :\n" + super.toString() + " \nThe subjects are: " + s + "\nThe price of the course after discount: " + PriceAfterDiscount;
        } else {
            return "Qudrat :\n" + super.toString() + " \nThe subjects are: " + s;
        }
    }

    /**
     * Overriding the super's equals method
     *
     * @return a boolean value.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
