package ge.exchangeservicegela.servlet;

import ge.exchangeservicegela.beans.User;
import ge.exchangeservicegela.dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alex on 6/10/2015.
 */
@WebServlet("/verification")
public class Verification extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("verified user");
        int id = Integer.parseInt(request.getParameter("userID"));
        Dao dao = new Dao();
        User u = dao.getUserByID(id);
        u.setIsConfirmed(true);
        dao.updateUser(u);

        request.getSession().setAttribute("user", u);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
