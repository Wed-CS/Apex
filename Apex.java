package apex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Main class to handle the Apex educational platform application. Provides
 * functionality for teachers and students to manage courses, enrollments, and
 * personal accounts. Teachers can add or remove courses, while students can
 * subscribe or unsubscribe from courses.
 *
 * @author Amal Adel
 * @author Basma Yaqoob
 * @author Esraa AbdElraheem
 * @author Mashael Shaker
 * @author Shaima Fuad
 * @author Wed Badahdah
 *
 * Supervised by : Dr.Azhar Alhindi.
 */
public class Apex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List to store students and teachers
        ArrayList<Student> studentsList = new ArrayList<>();
        ArrayList<Teacher> teachersList = new ArrayList<>();

        // Adding sample teachers to the list
        teachersList.add(new Teacher(105, "Emad", "Emad@gmail.com", "Emad12345", 1, 1, 1990, 12));
        teachersList.add(new Teacher(103, "Nora", "Nora@gmail.com", "Nora12345", 1, 1, 1990, 5));
        teachersList.add(new Teacher(102, "Nasser", "Nasser@gmail.com", "Nasser12345", 1, 1, 1990, 2));
        teachersList.add(new Teacher(101, "Retaj", "Retaj@gmail.com", "Retaj12345", 1, 1, 1990, 4));
        teachersList.add(new Teacher(104, "Ahmad", "Ahmad@gmail.com", "Ahmad12345", 1, 1, 1990, 7));

        // Adding sample students to the list
        studentsList.add(new Student(205, "Wed", "Wed@gmail.com", "Wed12345", 1, 1, 2005, 100));
        studentsList.add(new Student(203, "Mashael", "Mashael@gmail.com", "Mashael12345", 1, 1, 2005, 100));
        studentsList.add(new Student(204, "Amal", "Amal@gmail.com", "Amal12345", 1, 1, 2005, 100));
        studentsList.add(new Student(201, "Shaima", "Shaima@gmail.com", "Shaima12345", 1, 1, 2004, 100));
        studentsList.add(new Student(206, "Basmah", "Basmah@gmail.com", "Basmah12345", 1, 1, 2004, 100));
        studentsList.add(new Student(202, "Esraa", "Esraa@gmail.com", "Esraa12345", 1, 1, 2005, 100));

        Collections.sort(studentsList);

        // Creating Qudrat and SAAT courses
        Qudrat q1 = new Qudrat();
        SAAT s1 = new SAAT();
        int user = 0;
        String mainPassword = " ";

        // Display platform introduction
        System.out.println("Welcome to Apex Educational Platform!");
        System.out.println(
                "Here, you can find courses to help you achieve the highest scores on the SAAT and Qudrat tests.");
        System.out.println("Let's get started! Please select your role:");

        // Main loop for user interaction (teacher or student)
        while (user != 3) {
            System.out.println("\n1) Teacher");
            System.out.println("2) Student");
            System.out.println("3) Exit");
            System.out.print("Please enter your choice (1-3): ");
            user = scanner.nextInt();

            switch (user) {
                case 1: { // Teacher mode
                    Teacher teacher = teachersList.get(0); // For demo purposes, use the first teacher
                    teacher.addQudrat(q1);
                    teacher.addSAAT(s1);

                    int tchoice = 0;
                    while (true) {
                        System.out.println("\n--- Teacher Menu ---");
                        System.out.println("1) View all available courses (Qudrat and SAAT)");
                        System.out.println("2) View Qudrat courses only");
                        System.out.println("3) View SAAT courses only");
                        System.out.println("4) View all student information");
                        System.out.println("5) Search for a student by ID");
                        System.out.println("6) Log out");
                        System.out.print("Select an option (1-6): ");

                        tchoice = scanner.nextInt();

                        switch (tchoice) {
                            case 1: // Print all courses
                                System.out.println("\n--- All Available Courses ---");
                                System.out.println(q1.toString());
                                System.out.println("");
                                System.out.println(s1.toString());
                                break;
                            case 2: // Print Qudrat courses
                                System.out.println("\n--- Qudrat Courses ---");
                                System.out.println(q1.toString());
                                break;
                            case 3: // Print SAAT courses
                                System.out.println("\n--- SAAT Courses ---");
                                System.out.println(s1.toString());
                                break;
                            case 4: // Print all student information
                                System.out.println("\n--- Student Information ---");
                                Collections.sort(studentsList);
                                for (Student t : studentsList) {
                                    System.out.println(t.toString() + "\n---------------------------");
                                }
                                break;
                            case 5: // Search for a student by ID
                                System.out.print("Enter the Student ID you want to search: ");
                                int studentId = scanner.nextInt();
                                System.out.println("");
                                boolean studentFound = false;

                                for (Student student : studentsList) {
                                    if (student.getID() == studentId) {
                                        System.out.println("Student found: \n" + student);
                                        studentFound = true;
                                        break;
                                    }
                                }

                                if (!studentFound) {
                                    System.out.println("Sorry, no student found with that ID.");
                                }
                                break;
                            case 6: // Log out from teacher mode
                                System.out.println("\nLogging out...");
                                break;
                            default:
                                System.out.println("Invalid choice, please try again.");
                        }

                        if (tchoice == 6) {
                            break; // Exit the teacher menu loop
                        }
                    }
                    break; // End teacher mode
                }
                case 2: { // Student mode
                    long userid = 0;
                    int index = -1; //--------------------------------------------------------------------------
                    System.out.println("\nPlease choose:");
                    System.out.println("1) Create a New Account");
                    System.out.println("2) Log In with an existing account");
                    System.out.print("Enter your choice: ");
                    int login = scanner.nextInt();
                    if (login < 1 || login > 2) {
                        throw new ArithmeticException("Invalid choice, please try again.");
                    } else {

                        if (login == 1) { // Create a new account
                            index = studentsList.size();
                            int i = studentsList.size() - 1;
                            userid = studentsList.get(i).getID() + 1;
                            System.out.print("Enter your name: ");
                            String username = scanner.next();
                            System.out.print("Enter your email: ");
                            String useremail = scanner.next();
                            System.out.print("Enter your password: ");
                            String userpassword = scanner.next();
                            int userday;
                            while (true) {
                                System.out.print("Enter your birth day (1-31): ");
                                userday = scanner.nextInt();
                                if (userday >= 1 && userday <= 31) {
                                    break;
                                } else {
                                    System.out.println("Invalid day. Please enter a day between 1 and 31.");
                                }
                            }
                            int usermonth;
                            while (true) {
                                System.out.print("Enter your birth month (1-12): ");
                                usermonth = scanner.nextInt();
                                if (usermonth >= 1 && usermonth <= 12) {
                                    break;
                                } else {
                                    System.out.println("Invalid month. Please enter a month between 1 and 12.");
                                }
                            }
                            int useryear;
                            while (true) {
                                System.out.print("Enter your birth year: ");
                                useryear = scanner.nextInt();
                                if (useryear >= 1900 && useryear <= 2024) {
                                    break;
                                } else {
                                    System.out.println("Invalid year. Please enter a year between 1900 and 2024");
                                }
                            }
                            int usergrade;
                            while (true) {
                                System.out.print("Enter your current grade: ");
                                usergrade = scanner.nextInt();
                                if (usergrade >= 0) { // Accept grades that are 0 or positive
                                    break;
                                } else {
                                    System.out.println("Invalid grade. Please enter a positive number or 0.");
                                }
                            }

                            System.out.println("Your new account ID is " + userid);

                            studentsList.add(new Student(userid, username, useremail, userpassword, userday, usermonth,
                                    useryear, usergrade));

                        } else if (login == 2) { // Log in with existing account
                            System.out.print("Enter your Student ID: ");

                            userid = scanner.nextLong();
                            System.out.print("Enter your Password: ");
                            mainPassword = scanner.next();
                            for (int i = 0; i < studentsList.size(); i++) {
                                if (studentsList.get(i).getID() == userid) {
                                    index = i;

                                    String stPassword = (studentsList.get(index)).getPassword();
                                    if (stPassword.equals(mainPassword)) {
                                        System.out.print("You have successfully logged in. ");
                                    } else {
                                        System.out.print("Password is wrong");
                                        index = -2;
                                    }
                                }
                                //if password  ID not found from student
                            }
                            if (index == -1) {
                                System.out.print("The ID not found");
                                break;
                            }
                            //if password is wrong out from student
                            if (index == -2) {

                                break;
                            }
                        }
                    }

                    Student student = studentsList.get(index); // Access the student's account
                    int schoice = 0;

                    while (true) {
                        System.out.println("\n--- Student Menu ---");
                        System.out.println("1) View all available courses");
                        System.out.println("2) Subscribe to Qudrat courses");
                        System.out.println("3) Subscribe to SAAT courses");
                        System.out.println("4) View all teacher information");
                        System.out.println("5) Search for a specific course");
                        System.out.println("6) Get a hint for the discount code ;)");
                        System.out.println("7) Add a Qudrat course to the platform");
                        System.out.println("8) Add a SAAT course to the platform");
                        System.out.println("9) Remove a Qudrat course from your subscriptions");
                        System.out.println("10) Remove a SAAT course from your subscriptions");
                        System.out.println("11) View all courses you are subscribed to");
                        System.out.println("12) Reset your password");
                        System.out.println("13) Update your profile");
                        System.out.println("14) Log out");
                        System.out.print("Select an option (1-14): ");

                        schoice = scanner.nextInt();

                        String mainName = " ";
                        String mainEmail = " ";

                        switch (schoice) {
                            case 1: // Print all available courses
                                System.out.println("\n--- Available Courses ---");
                                System.out.println(q1.toString());
                                System.out.println("");
                                System.out.println(s1.toString());
                                break;
                            case 2: // Subscribe to Qudrat courses
                                System.out.print("Enter discount code (if any): ");
                                String discountCode1 = scanner.next();
                                System.out.println("");
                                studentsList.get(index).setStudentCourse(new Qudrat());
                                for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                    if (studentsList.get(index).getStudentCourse().get(i) instanceof Qudrat) {
                                        ((Qudrat) (studentsList.get(index).getStudentCourse().get(i)))
                                                .codeDiscount(discountCode1);
                                        System.out.println("You have successfully subscribed to Qudrat courses!");
                                        System.out.println(((Qudrat) (studentsList.get(index).getStudentCourse().get(i))).toString());
                                    }
                                }
                                break;
                            case 3: // Subscribe to SAAT courses
                                System.out.print("Enter discount code (if any): ");
                                String discountCode2 = scanner.next();
                                studentsList.get(index).setStudentCourse(new SAAT());
                                for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                    if (studentsList.get(index).getStudentCourse().get(i) instanceof SAAT) {
                                        ((SAAT) (studentsList.get(index).getStudentCourse().get(i)))
                                                .codeDiscount(discountCode2);
                                        System.out.println("You have successfully subscribed to SAAT courses!");
                                        System.out.println(((SAAT) (studentsList.get(index).getStudentCourse().get(i)))
                                                .toString());
                                    }
                                }
                                break;
                            case 4: // View all teachers' information
                                System.out.println("\n--- Teachers Information --- \n");
                                Collections.sort(teachersList);
                                for (Teacher t : teachersList) {
                                    System.out.println(t.toString() + "\n---------------------------");
                                }
                                break;
                            case 5: // Search for a course by subject
                                System.out.print("Enter the type of course (Qudrat or SAAT): ");
                                String course = scanner.next();
                                scanner.nextLine(); // Consume newline
                                System.out.print("Enter the subject you want to search for: ");
                                String subject = scanner.nextLine();

                                boolean courseFound = false; // Flag to track if any course is found

                                if (course.equalsIgnoreCase("Qudrat")) {
                                    for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                        if (studentsList.get(index).getStudentCourse().get(i) instanceof Qudrat) {
                                            ((Qudrat) (studentsList.get(index).getStudentCourse().get(i)))
                                                    .searchCourse(subject);
                                            courseFound = true; // A course has been found
                                        }
                                    }
                                    if (!courseFound) {
                                        System.out.println("You didn't subscribe to any Qudrat course.");
                                    }
                                } else if (course.equalsIgnoreCase("SAAT")) {
                                    for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                        if (studentsList.get(index).getStudentCourse().get(i) instanceof SAAT) {
                                            ((SAAT) (studentsList.get(index).getStudentCourse().get(i)))
                                                    .searchCourse(subject);
                                            courseFound = true; // A course has been found
                                        }
                                    }
                                    if (!courseFound) {
                                        System.out.println("You didn't subscribe to any SAAT course.");
                                    }
                                } else {
                                    System.out.println("Invalid course type. Please enter either 'Qudrat' or 'SAAT'.");
                                }
                                break;

                            case 6: // Provide hint for discount code
                                System.out.println(
                                        "Hint: I am a land of deserts and dreams, where the sun shines bright and the sea gleams.\nHome to a holy place, so revered. In the heart of the Middle East, I'm cheered.\nWhat am I?");
                                System.out.println("Hint: Use capital letters and country abbreviation.");
                                break;
                            case 7: // Add a Qudrat course
                                System.out.println("Note: You can only add Math or Arabic courses.");
                                System.out.print("Enter the name of the Qudrat course to add: ");
                                String qudratCourse = scanner.next();
                                for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                    if (studentsList.get(index).getStudentCourse().get(i) instanceof Qudrat) {
                                        ((Qudrat) (studentsList.get(index).getStudentCourse().get(i)))
                                                .addCourse(qudratCourse);
                                    }
                                }
                                break;
                            case 8: // Add a SAAT course
                                System.out.println("Note: You can only add Biology, Chemistry, or Physics courses.");
                                System.out.print("Enter the name of the SAAT course to add: ");
                                String saatCourse = scanner.next();
                                for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                    if (studentsList.get(index).getStudentCourse().get(i) instanceof SAAT) {
                                        ((SAAT) (studentsList.get(index).getStudentCourse().get(i)))
                                                .addCourse(saatCourse);
                                    }
                                }
                                break;
                            case 9: // Delete a Qudrat course
                                System.out.print("Enter the name of the Qudrat course to delete: ");
                                String deleteQudratCourse = scanner.next();
                                for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                    if (studentsList.get(index).getStudentCourse().get(i) instanceof Qudrat) {
                                        ((Qudrat) (studentsList.get(index).getStudentCourse().get(i)))
                                                .deleteCourse(deleteQudratCourse);
                                    }
                                }
                                break;
                            case 10: // Delete a SAAT course
                                System.out.print("Enter the name of the SAAT course to delete: ");
                                String deleteSaatCourse = scanner.next();
                                for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                    if (studentsList.get(index).getStudentCourse().get(i) instanceof SAAT) {
                                        ((SAAT) (studentsList.get(index).getStudentCourse().get(i)))
                                                .deleteCourse(deleteSaatCourse);
                                    }
                                }
                                break;
                            case 11: // View all subscribed courses
                                System.out.println("\n--- Your Subscribed Courses ---");
                                for (int i = 0; i < studentsList.get(index).getStudentCourse().size(); i++) {
                                    System.out.println(studentsList.get(index).getStudentCourse().get(i).toString());
                                    System.out.println("---------------------------------------------------------");
                                }
                                break;
                            case 12: // reset Password
                            {
                                boolean flag = false;
                                while (!flag) {
                                    System.out.println("Enter your current password:");
                                    mainPassword = scanner.next();
                                    if (mainPassword.equals(studentsList.get(index).getPassword())) {
                                        System.out.println("Enter your new password:");
                                        String newPassword = scanner.next();
                                        studentsList.get(index).resetPassword(newPassword);
                                        flag = true;
                                    } else {
                                        System.out.println("Your current password is wrong!");
                                        System.out.println(" ");
                                    }
                                } // while
                            } // case 12
                            break;
                            case 13: {

                                boolean flag = false;
                                while (!flag) {
                                    System.out.println("Enter your current Name: ");
                                    mainName = scanner.next();
                                    System.out.println("Enter your current Email: ");
                                    mainEmail = scanner.next();

                                    if (mainName.equals(studentsList.get(index).getName()) && mainEmail.equals(studentsList.get(index).getEmail())) {
                                        System.out.println("Enter a new Name:");
                                        String newName = scanner.next();
                                        System.out.println("Enter a new Email");
                                        String newEmail = scanner.next();
                                        studentsList.get(index).updateProfile(newName, newEmail);
                                        flag = true;

                                    } else {
                                        System.out.println("Your current Name/Email is wrong!");
                                        System.out.println(" ");

                                    } //else
                                }//while
                            } // case 13
                            break;

                            case 14: // Log out from student mode
                                studentsList.get(index).logout();
                                break;
                            default:
                                System.out.println("Invalid choice, please try again.");
                        }

                        if (schoice == 14) {
                            break; // Exit the student menu loop
                        }
                    }
                    break; // End student mode
                }

                case 3: // Exit the application
                    System.out.println("Thank you for using Apex. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, please enter 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}