package apex;

/**
 * Represents a teacher in the Apex educational platform. Manages courses,
 * certificates, and experience, and supports adding, deleting, and searching
 * for courses, certificates, and teachers.
 *
 * Implements `Comparable` to allow sorting by teacher ID.
 *
 * @author Wed
 */
import java.util.ArrayList;

public class Teacher extends User implements Comparable {

    private int Experience;
    private ArrayList<course> TeacherCourses;

    // Constructors
    public Teacher() {
        super();
        TeacherCourses = new ArrayList<course>();
    }

    public Teacher(long ID, String name, String email, String password, int day, int month, int year, int Experience) {
        super(ID, name, email, password, day, month, year);
        this.Experience = Experience;
        TeacherCourses = new ArrayList<course>();
    }

    private void initializeCollections() {
        TeacherCourses = new ArrayList<>();
    }

    //setter and getter
    public int getExperience() {
        return Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }

    public ArrayList<course> getTeacherCourses() {
        return TeacherCourses;
    }

    public void setTeacherCourses(ArrayList<course> teacherCourses) {
        TeacherCourses = teacherCourses;
    }

    //add
    public void addQudrat(Qudrat q) {
        TeacherCourses.add(q);
    }

    public void addSAAT(SAAT s) {
        TeacherCourses.add(s);
    }

    //Increase teacher experience
    public void IncreaseExperience(int e) {
        this.Experience = this.Experience + e;
    }

    //compareTo
    @Override
    public int compareTo(Object obj) {
        Teacher t = (Teacher) obj;
        if (this.getID() > t.getID()) {
            return 1;
        } else if (this.getID() < t.getID()) {
            return -1;
        } else {
            return 0;
        }
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + "\nExperience: " + Experience;
    }
}