package ge.exchangeservicegela.beans;

/**
 * Created by Alex on 6/9/2015.
 */
public class User{

        private int userID;
        private String email;
        private String phoneNumber;
        private String password;
        private String firstName;
        private String lastName;
        private boolean isSatisfied;
        private int locationID;
        private  boolean isConfirmed;

    public User() {

    }

    public User(int userID, String email, String phoneNumber, String password, String firstName, String lastName, boolean isSatisfied, int locationID, boolean isConfirmed) {
        this.userID = userID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isSatisfied = isSatisfied;
        this.locationID = locationID;
        this.isConfirmed = isConfirmed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isSatisfied() {
        return isSatisfied;
    }

    public void setIsSatisfied(boolean isSatisfied) {
        this.isSatisfied = isSatisfied;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
}
