package ge.exchangeservicegela.dao;

import com.mysql.fabric.xmlrpc.base.Array;
import ge.exchangeservicegela.beans.Location;
import ge.exchangeservicegela.beans.User;
import ge.exchangeservicegela.db.DBConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alex on 6/9/2015.
 */
public class Dao {

    public  User loginUser(String email,String password) {
        User ret;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("select * FROM Users WHERE  Users.email=? AND Users.password=?")) {
                st.setString(1, email);
                st.setString(2, password);
                ResultSet res = st.executeQuery();
                if (!res.next()) {
                    return null;
                }
                ret = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(7),res.getBoolean(8),res.getInt(9),res.getBoolean(10));
            }
        } catch (SQLException e) {
            ret = null;
        }
        return ret;
    }

    public boolean removeUser(String email,String password){
        boolean errorCode = false;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("DELETE FROM Users WHERE  Users.email=? AND Users.password=?")) {
                st.setString(1, email);
                st.setString(2, password);
                st.executeUpdate();
            }
        } catch (SQLException e) {
            errorCode = true;
        }
        return errorCode;
    }

    public boolean setVerified(int userID){
        boolean errorCode = false;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("UPDATE Users SET confimed=true WHERE userID=?")) {
                st.setInt(1,userID);
                st.executeUpdate();
            }
        } catch (SQLException e) {
            errorCode = true;
        }
        return errorCode;
    }



    public boolean addUser(User user){
        boolean errorCode = false;
        user.setIsSatisfied(false);
        user.setIsConfirmed(false);

        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("INSERT INTO " +
                    "Users(userID,email,phoneNumber,password,firstName,lastName,isSatisfied,locationID,confirmed) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)")) {
                st.setInt(1,user.getUserID());
                st.setString(2,user.getEmail());
                st.setString(3,user.getPhoneNumber());
                st.setString(4,user.getPassword());
                st.setString(5,user.getFirstName());
                st.setString(6,user.getLastName());
                st.setBoolean(7,user.isSatisfied());
                st.setInt(8,user.getLocationID());
                st.setBoolean(9,user.isConfirmed());
                st.executeUpdate();
            }
        } catch (SQLException e) {
            errorCode = true;
        }
        return errorCode;

    }

    public ArrayList<Location> getLocations(){
        ArrayList<Location> ret = new ArrayList<>();
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("select * FROM location")) {
                ResultSet res = st.executeQuery();
                while (res.next()){
                    Location loc = new Location(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
                    ret.add(loc);
                }
            }
        } catch (SQLException e) {
            ret = null;
        }
        return ret;
    }

    private User getUserByID(int userID){
        User ret;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("select * FROM Users WHERE  Users.userID=?")) {
                st.setInt(1, userID);
                ResultSet res = st.executeQuery();
                if (!res.next()) {
                    return null;
                }
                ret = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(7),res.getBoolean(8),res.getInt(9),res.getBoolean(10));
            }
        } catch (SQLException e) {
            ret = null;
        }
        ret.setPassword("");
        return ret;
    }

    public ArrayList<User> getMewyvile(int userID){
        ArrayList<User> ret = new ArrayList<>();
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("" +
                    " SELECT u.userID FROM " +
                    " Pairs, " +
                    " Users AS u " +
                    " WHERE u.isSatisfied=FALSE AND u. Pairs.userID=? AND Pairs.locationID=u.locationID " +
                    " ORDER BY u.userID ")) {
                st.setInt(1, userID);
                ResultSet res = st.executeQuery();
                while(res.next()){
                    int id = res.getInt(1);
                    ret.add(getUserByID(id));
                }
            }
        } catch (SQLException e) {
            ret = null;
        }
        return  ret;

    }

    public  boolean addSadUnda(int userID,int placeID){
        boolean errorCode = false;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("insert into Pairs(userID,locationID) VALUES (?,?)")) {
                st.setInt(1, userID);
                st.setInt(2,placeID);
                ResultSet res = st.executeQuery();
                if (!res.next()) {
                    errorCode = false;
                }
            }
        } catch (SQLException e) {
            errorCode = true;
        }
        return  errorCode;
    }




}
