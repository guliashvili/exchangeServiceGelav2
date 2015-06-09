package ge.exchangeservicegela.beans;

/**
 * Created by GIO on 6/10/2015.
 */
public class Pairs {
    private int pairID;
    private int userID;
    private int locationID;

    public int getPairID() {
        return pairID;
    }

    public void setPairID(int pairID) {
        this.pairID = pairID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public Pairs(int pairID, int userID, int locationID) {

        this.pairID = pairID;
        this.userID = userID;
        this.locationID = locationID;
    }
}
