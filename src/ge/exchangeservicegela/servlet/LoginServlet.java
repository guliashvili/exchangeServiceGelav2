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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AllManager manager = (AllManager) getServletContext().getAttribute(AllManager.class.getName());

        if (email != null && password != null) {
            User user = manager.loginUser(email, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
            }
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException();
    }
}
