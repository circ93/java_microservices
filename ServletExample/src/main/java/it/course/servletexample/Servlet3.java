package it.course.servletexample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Servlet3", value = "/servlet_form1")
public class Servlet3 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jspPage = "page2.jsp";
        String nome = request.getParameter("inputName");
        request.setAttribute("nomeForm", nome);
        RequestDispatcher view = request.getRequestDispatcher(jspPage);
        view.forward(request, response);

    }

}
