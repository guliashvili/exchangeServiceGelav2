package ge.exchangeservicegela.servlet;

import ge.exchangeservicegela.beans.User;
import ge.exchangeservicegela.dao.Dao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by GIO on 6/10/2015.
 */
public class bla {
    public static void upd(HttpServletRequest request) {
        try {
            Dao dao = new Dao();
            User u = (User) request.getSession().getAttribute("user");
            request.getSession().setAttribute("user", dao.loginUser(u.getEmail(), u.getPassword()));
        } catch (Exception e) {

        }
    }
}
