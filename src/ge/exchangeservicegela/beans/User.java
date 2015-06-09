package ge.exchangeservicegela.beans;

/**
 * Created by Alex on 6/9/2015.
 */
public class User{

        private int userID;
        private String phoneNumber;
        private String password;
        private String firstName;
        private String lastName;
        private String googleID;
        private boolean isSatisfied;
        private int locationID;

    public User(int userID, String phoneNumber, String password, String firstName, String lastName, String googleID, boolean isSatisfied, int locationID) {
        this.userID = userID;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.googleID = googleID;
        this.isSatisfied = isSatisfied;
        this.locationID = locationID;
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

    public String getGoogleID() {
        return googleID;
    }

    public void setGoogleID(String googleID) {
        this.googleID = googleID;
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
