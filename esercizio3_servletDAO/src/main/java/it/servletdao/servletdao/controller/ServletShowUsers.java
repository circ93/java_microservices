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
import java.util.List;

@WebServlet(name = "ServletShowUsers", value = "/servlet-show-users")
public class ServletShowUsers extends HttpServlet {

    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userDAO.selectAllUsers();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("show-users.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        String msg_delete = req.getParameter("msg_delete");

        //messaggio dalla Servlet
        if (status != null){
            req.setAttribute("msg_update", status);
        }
        //messaggio dalla servlet Delete User
        if (msg_delete != null){
            req.setAttribute("msg_delete", msg_delete);
        }

        List<User> users = userDAO.selectAllUsers();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("show-users.jsp");
        dispatcher.forward(req,resp);
    }


}
