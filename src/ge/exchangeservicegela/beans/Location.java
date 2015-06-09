package ge.exchangeservicegela.beans;

/**
 * Created by GIO on 6/9/2015.
 */
public class Location {
    private int locationID ;
    private String startDate;
    private String endDate;
    private String locationName;

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Location(int locationID, String startDate, String endDate, String locationName) {
        this.locationID = locationID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.locationName = locationName;
    }
}
