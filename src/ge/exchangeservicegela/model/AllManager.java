package ge.exchangeservicegela.model;

import ge.exchangeservicegela.beans.Location;
import ge.exchangeservicegela.beans.User;
import ge.exchangeservicegela.dao.Dao;
import ge.exchangeservicegela.helper.Check;

import java.util.ArrayList;

/**
 * Created by GIO on 6/10/2015.
 */
public class AllManager {
    private  Dao dao;

    public AllManager(Dao dao) {
        this.dao = dao;
    }

    public  boolean addUser(User user){
        if(user == null) return  true;
        if(!Check.isValidEmail(user.getEmail())) return  true;
        if (!Check.isValidPhoneNumber(user.getPhoneNumber())) return true;
        return  dao.addUser(user);
    }

    public  boolean updateUser(User user){
        if(user == null) return  true;
        return  dao.updateUser(user);

    }

    /*public boolean removeUser(String email,String password){
        return  dao.removeUser(email,password);
    }
    public  boolean setVerified(int userID){
        return  dao.setVerified(userID);
    }*/
    public  User loginUser(String email,String password){
        if(email == null || password == null) return  null;
        return  dao.loginUser(email,password);
    }
    public ArrayList<Location> getLocations(){
        return  dao.getLocations();
    }
    public ArrayList<User> getMewyvile(int userID){
        return  dao.getMewyvile(userID);
    }

    public  boolean addSadUnda(int userId,int placeID){
        return  dao.addSadUnda(userId,placeID);
    }
    public  boolean clearSadUnda(int userId){
        return  dao.clearSadUnda(userId);
    }
}
