package it.servletdao.servletdao.controller;
import it.servletdao.servletdao.dao.UserDAO;
import it.servletdao.servletdao.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

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

        Integer id = Integer.parseInt(request.getParameter("id"));


        try {
            userDAO.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        request.setAttribute("msg", "L'utente è stato eliminato dal DB!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request,response);
    }
}
