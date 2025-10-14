package apex;

/**
 * Represents a user in the Apex platform, with attributes for ID, name, email,
 * password, and date of birth. Provides methods for login, logout, profile
 * update, and password reset.
 *
 * The class also includes a default constructor and a parameterized constructor
 * to initialize user details.
 *
 * @author Shaima fuad
 */
public class User {

    private long ID;
    private String name;
    private String email;
    private String password;
    private dateOfBirth dateOfBirth;

    public User() {
        dateOfBirth = new dateOfBirth();
    }

    public User(long ID, String name, String email, String password, int day, int month, int year) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        dateOfBirth = new dateOfBirth(day, month, year);
    }

    //-------------------------------------------------------------------------------------------
    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public dateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(dateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    //------------------------------------------------------------------

    /**
     * This method is used to log out
     *
     */
    public void logout() {
        System.out.println(name + " log out...");
    }

    /**
     * This method is used to reset the password
     *
     * @para newPassword This parameter takes the new password from the user
     */
    public void resetPassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Reset password successfully!");
    }

    /**
     * This method is used to update the profile by changing the name and email
     *
     * @para newName
     * @para newEmail
     *
     */
    public void updateProfile(String newName, String newEmail) {
        if (newName != null && !newName.isEmpty() && newEmail != null && !newEmail.isEmpty()) {
            this.name = newName;
            this.email = newEmail;
            System.out.println("Profile updated.");
        } else {
            System.out.println("Something wrong in profile update!");
        }

    }

    @Override
    public String toString() {
        return "ID: " + ID + "\nName: " + name + "\nEmail: " + email + "\nDateOfBirth: " + dateOfBirth;
    }
}