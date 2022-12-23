package it.servletdao.servletdao.controller;

import it.servletdao.servletdao.dao.UserDAO;
import it.servletdao.servletdao.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletUpdateUser", value = "/servlet-update-user")
public class ServletUpdateUser extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Integer eta = Integer.parseInt(request.getParameter("eta"));

        User editUser = new User(id, name, email, country, eta);
        try {
            userDAO.updateUser(editUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("status", "Utente aggiornato correttamente!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("servlet-show-users");
        dispatcher.forward(request,resp);

    }
}
