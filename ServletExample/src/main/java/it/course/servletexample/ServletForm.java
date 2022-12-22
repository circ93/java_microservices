package it.course.servletexample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "ServletForm", value = "/servlet_login")
public class ServletForm extends HelloServlet{

    private final String user = "gianluca";
    private final String pass = "pippo";

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jspPage = "page3.jsp";

        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String email = request.getParameter("email");


        if (username.equals(user) && password.equals(pass)){
            request.setAttribute("user", username);
            request.setAttribute("email", email);
            RequestDispatcher view1 = request.getRequestDispatcher(jspPage);
            view1.forward(request, response);
        } else {
            RequestDispatcher view2 = request.getRequestDispatcher("servlet-error");
            view2.forward(request, response);
        }

    }
}
