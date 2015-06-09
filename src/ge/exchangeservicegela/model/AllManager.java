package ge.exchangeservicegela.model;

import ge.exchangeservicegela.beans.Location;
import ge.exchangeservicegela.beans.User;
import ge.exchangeservicegela.dao.Dao;

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
        return  dao.addUser(user);
    }

    public boolean removeUser(String email,String password){
        return  dao.removeUser(email,password);
    }
    public  boolean setVerified(int userID){
        return  dao.setVerified(userID);
    }
    public  User loginUser(String email,String password){
        return  dao.loginUser(email,password);
    }
    public ArrayList<Location> getLocations(){
        return  dao.getLocations();
    }

}
