package it.course.servletexample;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "Servlet2", value = "/servlet2")
public class Servlet2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspPage = "page1.jsp";
        String name = "Gianluca";
        request.setAttribute("nome", name);
        RequestDispatcher view = request.getRequestDispatcher(jspPage);
        view.forward(request, response);
    }

}
