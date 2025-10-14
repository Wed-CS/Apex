package apex;

/**
 * Represents a student in the Apex educational platform. Manages courses
 * (Qudrat and SAAT), student information, and course enrollment. Supports
 * adding, deleting, and searching for courses and students.
 *
 * Implements `Comparable` to allow sorting by student ID.
 *
 * @author Basmah Yaqoob
 *
 */
import java.util.ArrayList;

public class Student extends User implements Comparable {

    private int grade;
    private ArrayList<course> StudentCourse;

    // defult Constructors
    public Student() {
        super();
        StudentCourse = new ArrayList<course>();
    }

    // pramater Constructor
    public Student(long ID, String name, String email, String password, int day, int month, int year, int grade) {
        super(ID, name, email, password, day, month, year);
        this.grade = grade;
        StudentCourse = new ArrayList<course>();
    }
    // setter and getter

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public ArrayList<course> getStudentCourse() {
        return StudentCourse;
    }

    // setStudentCourse
    public void setStudentCourse(course StudentCourse) {
        if (!this.StudentCourse.contains(StudentCourse)) {
            this.StudentCourse.add(StudentCourse);
        } else {
            System.out.println("This course is already subscribed.");
        }
    }

    // Increase student grades
    public void gradeIncrease(int g) {
        this.grade = this.grade + g;

    }

    // compareTo
    @Override
    public int compareTo(Object obj) {
        Student st = (Student) obj;
        if (this.getID() > st.getID()) {
            return 1;
        } else if (this.getID() < st.getID()) {
            return -1;
        } else {
            return 0;
        }
    }

    // to string
    @Override
    public String toString() {
        return super.toString() + "\nStudent's grade: " + grade;
    }
}
