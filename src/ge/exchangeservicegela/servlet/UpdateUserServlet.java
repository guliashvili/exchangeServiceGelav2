package ge.exchangeservicegela.servlet;

import ge.exchangeservicegela.beans.User;
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
        String locationHave = request.getParameter("locationHave");

        String[] locationWant = request.getParameterMap().get("locationWant");

        if (locationHave != null && locationWant != null) {
            User user = (User) request.getSession().getAttribute("user");

            user.setLocationID(Integer.parseInt(locationHave));

            AllManager manager = (AllManager) getServletContext().getAttribute(AllManager.class.getName());

            manager.clearSadUnda(user.getUserID());

            for (String s : locationWant) {
                manager.addSadUnda(Integer.parseInt(locationHave), Integer.parseInt(s));
            }

            getServletContext().getRequestDispatcher("/preferences.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("satisfy") != null) {
            User user = (User) request.getSession().getAttribute("user");

            user.setIsSatisfied(true);

            AllManager manager = (AllManager) getServletContext().getAttribute(AllManager.class.getName());

            manager.updateUser(user);

            getServletContext().getRequestDispatcher("/preferences.jsp").forward(request, response);
        }
    }
}
