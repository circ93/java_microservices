package it.servletdao.servletdao.controller;
import it.servletdao.servletdao.dao.UserDAO;
import it.servletdao.servletdao.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ServletInserUser", value = "/ServletInserUser")
public class ServletInserUser extends HttpServlet {
    private UserDAO userDAO;
    public void init() {
        userDAO = new UserDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Integer eta = Integer.parseInt(request.getParameter("eta"));

        User newUser = new User(name, email, country, eta);
        try {
            userDAO.insertUser(newUser);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
            response.sendRedirect("error-page.jsp");
        }

        request.setAttribute("msg_insert", "L'utente è stato inserito correttamente!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request,response);
    }
}
