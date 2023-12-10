package com.employees.system.servlet;

import com.employees.system.dao.LoginDao;
import com.employees.system.dao.UserDao;
import com.employees.system.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Sojib");
        resp.sendRedirect("index.jsp");    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        User user= loginDao.getUser(username,password);
        if (user != null) {
            request.setAttribute("errorMessage","");
            resp.sendRedirect("dashBoard.jsp");
        }else {
            // User does not exist
            // Set an error message attribute in the request to be displayed on the JSP
            request.setAttribute("errorMessage", "Invalid username or password");
            // Forward the request to the login page to display the error message
            request.getRequestDispatcher("index.jsp").forward(request, resp);


        }
    }
}
