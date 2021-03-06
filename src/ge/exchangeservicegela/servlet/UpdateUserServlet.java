package ge.exchangeservicegela.servlet;

import ge.exchangeservicegela.beans.User;
import ge.exchangeservicegela.dao.Dao;
import ge.exchangeservicegela.model.AllManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alex on 6/10/2015.
 */
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String locationHave = request.getParameter("locationHave");
        System.out.println("Updated");
        String[] locationWant = request.getParameterValues("locationWant");
        String toLink;
        if (locationHave != null && locationWant != null) {
            User user = (User) request.getSession().getAttribute("user");

            user.setLocationID(Integer.parseInt(locationHave));


            AllManager manager = (AllManager) getServletContext().getAttribute(AllManager.class.getName());
            manager.updateUser(user);

            manager.clearSadUnda(user.getUserID());

            for (String s : locationWant) {
                manager.addSadUnda(user.getUserID(), Integer.parseInt(s));
            }
            toLink = "/preferences.jsp";
        } else
            toLink = "/index.jsp";

        Dao dao = new Dao();
        try {
            User user = (User) request.getSession().getAttribute("user");
            request.getSession().setAttribute("user", dao.loginUser(user.getEmail(), user.getPassword()));
        } catch (Exception e) {
        }

        getServletContext().getRequestDispatcher(toLink).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("user");
        AllManager manager = (AllManager) getServletContext().getAttribute(AllManager.class.getName());

        if (request.getParameter("minda") != null) {
            user.setIsSatisfied(false);
            manager.updateSat(user);
            System.out.println("UN RE SATISFIED");
        } else if (request.getParameter("agar") != null) {
            user.setIsSatisfied(true);
            manager.updateSat(user);
            System.out.println("SATISFIED");

        }


        getServletContext().getRequestDispatcher("/preferences.jsp").forward(request, response);
        }
}
