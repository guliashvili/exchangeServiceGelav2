package ge.exchangeservicegela.model;

import ge.exchangeservicegela.beans.User;
import ge.exchangeservicegela.dao.Dao;

/**
 * Created by GIO on 6/10/2015.
 */
public class allManager {
    private  Dao dao;
    public  allManager(Dao dao){
        this.dao = dao;
    }

    public  boolean addUser(User user){
        return  dao.addUser(user);
    }

    public boolean removeUser(String email,String password){
        dao.removeUser(email,password);
    }
    public  boolean setVerified(int userID){

    }
    public  User loginUser(String email,String password){

    }


}
