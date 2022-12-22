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

    String user;
    String pass;
    @Override
    public void init() {
        user = "gianluca";
        pass = "pippo";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jspPage = "page3.jsp";

        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String email = request.getParameter("email");

        if (Objects.equals(username, user) && Objects.equals(password, pass)){
            request.setAttribute("user", username);
            request.setAttribute("email", email);
            RequestDispatcher view1 = request.getRequestDispatcher(jspPage);
            view1.forward(request, response);
        } else {
            request.setAttribute("msg", "Ricompila il form, i dati inseriti non sono presenti nel DB");
            RequestDispatcher view2 = request.getRequestDispatcher("index.jsp");
            view2.forward(request, response);
        }

    }
}
