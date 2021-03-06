package ge.exchangeservicegela.servlet;

import ge.exchangeservicegela.beans.User;
import ge.exchangeservicegela.helper.EmailSender;
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
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = new User();

        user.setEmail(request.getParameter("email"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        user.setPassword(request.getParameter("password"));
        user.setLocationID(Integer.parseInt(request.getParameter("locationHave")));
        System.out.println("register user");
        AllManager manager = (AllManager) getServletContext().getAttribute(AllManager.class.getName());

        if (!manager.addUser(user)) {
            request.getSession().setAttribute("user",user);
            EmailSender.verifyEmail(user,"");
            getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);

        } else {
            getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        throw new UnsupportedOperationException();
    }
}
