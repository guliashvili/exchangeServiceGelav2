package ge.exchangeservicegela.dao;

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
    public boolean hasSelected(int userId, int locId) {
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("SELECT * FROM Pairs WHERE  userID=? AND locationID=?")) {
                st.setInt(1, userId);
                st.setInt(2, locId);
                ResultSet res = st.executeQuery();
                if (!res.next()) {
                    return false;
                }

            }
        } catch (SQLException e) {
        }
        return true;
    }
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
                ret = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getBoolean(7),res.getInt(8),res.getBoolean(9));
            }
        } catch (SQLException e) {
            ret = null;
        }
        return ret;
    }

    /*
    public boolean removeUser(String email,String password){
        boolean errorCode = false;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try(PreparedStatement st = con.)
            try (PreparedStatement st = con.prepareStatement("DELETE FROM Users WHERE  Users.email=? AND Users.password=?")) {
                st.setString(1, email);
                st.setString(2, password);
                st.executeUpdate();
            }
        } catch (SQLException e) {
            errorCode = true;
        }
        return errorCode;
    }*/

    public  boolean updateUser(User user){
        boolean errorCode = false;

        User userN = getUserByID(user.getUserID());
        if (userN.isConfirmed() && !user.isConfirmed()) user.setIsConfirmed(true);

        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("UPDATE Users SET " +
                    " phoneNumber=?,firstName=?,lastName=?,isSatisfied=?,locationID=?,confirmed=? " +
                    " WHERE email=? AND password=? ")) {

                st.setString(1,user.getPhoneNumber());
                st.setString(2,user.getFirstName());
                st.setString(3,user.getLastName());
                st.setBoolean(4,user.isSatisfied());
                st.setInt(5,user.getLocationID());
                st.setBoolean(6,user.isConfirmed());
                st.setString(7,user.getEmail());
                st.setString(8,user.getPassword());
                st.executeUpdate();
            }
        } catch (SQLException e) {
            errorCode = true;
        }
        return errorCode;
    }
    /*

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
*/


    public boolean addUser(User user){
        boolean errorCode = false;
        user.setIsSatisfied(false);
        user.setIsConfirmed(false);
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("INSERT INTO " +
                    "Users(email,phoneNumber,password,firstName,lastName,isSatisfied,locationID,confirmed) " +
                    "VALUES(?,?,?,?,?,?,?,?)")) {
                st.setString(1,user.getEmail());
                st.setString(2,user.getPhoneNumber());
                st.setString(3,user.getPassword());
                st.setString(4,user.getFirstName());
                st.setString(5,user.getLastName());
                st.setBoolean(6,user.isSatisfied());
                st.setInt(7,user.getLocationID());
                st.setBoolean(8,user.isConfirmed());
                st.executeUpdate();

                user.setUserID(loginUser(user.getEmail(), user.getPassword()).getUserID());
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

    public User getUserByID(int userID){
        User ret;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("select * FROM Users WHERE  Users.userID=?")) {
                st.setInt(1, userID);
                ResultSet res = st.executeQuery();
                if (!res.next()) {
                    return null;
                }
                ret = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getBoolean(7),res.getInt(8),res.getBoolean(9));
            }
        } catch (SQLException e) {
            ret = null;
        }
        return ret;
    }

    public ArrayList<User> getMewyvile(int userID){
        //System.out.print(userID);
        ArrayList<User> ret = new ArrayList<>();
        if(getUserByID(userID) == null) return  null;

        String selectAgrUni = "" +
                " SELECT u1.userID FROM Pairs p1,Pairs p2,Users AS u1,Users AS u2 " +
                " WHERE u1.isSatisfied=FALSE AND p1.userID = u1.userID " +
                " AND p2.userID=? AND p2.userID = u2.userID  AND p1.userID != p2.userID " +
                " AND p2.locationID=u1.locationID AND p1.locationID=u2.locationID " +
                " AND u1.email LIKE '%@agruni.edu.ge'" +
                " ORDER BY u1.userID ";
        String selectFreeUni = "" +
                " SELECT u1.userID FROM Pairs p1,Pairs p2,Users AS u1,Users AS u2 " +
                " WHERE u1.isSatisfied=FALSE AND p1.userID = u1.userID " +
                " AND p2.userID=? AND p2.userID = u2.userID  AND p1.userID != p2.userID " +
                " AND p2.locationID=u1.locationID AND p1.locationID=u2.locationID " +
                " AND u1.email LIKE '%@freeuni.edu.ge'" +
                " ORDER BY u1.userID ";

        String cur;
        String email = getUserByID(userID).getEmail();
        if (email.substring(email.length() - "@agruni.edu.ge".length()).equals("@agruni.edu.ge"))
            cur = selectAgrUni;
        else
            cur = selectFreeUni;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement(cur)) {
                st.setInt(1, userID);
                ResultSet res = st.executeQuery();
                while(res.next()){
                    int id = res.getInt(1);
                    User u = getUserByID(id);
                    u.setPassword("");
                    ret.add(getUserByID(id));

                }
            }
        } catch (SQLException e) {
            ret = null;
        }
        return  ret;

    }

    public  boolean addSadUnda(int userID,int placeID){
        //System.out.println(userID +" " + placeID);
        boolean errorCode = false;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("insert into Pairs(userID,locationID) VALUES (?,?)")) {
                st.setInt(1, userID);
                st.setInt(2,placeID);
                st.executeUpdate();

            }
        } catch (SQLException e) {
            errorCode = true;
        }
        return  errorCode;
    }

    public  boolean clearSadUnda(int userID){
        boolean errorCode = false;
        try (Connection con = DBConnectionProvider.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("DELETE FROM Pairs WHERE Pairs.userID=?")) {
                st.setInt(1, userID);
                st.executeUpdate();

            }
        } catch (SQLException e) {
            errorCode = true;
        }
        return  errorCode;
    }




}
