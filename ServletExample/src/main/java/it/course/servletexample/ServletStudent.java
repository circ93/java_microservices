package it.course.servletexample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletStudent", value = "/servlet_student")
public class ServletStudent extends HelloServlet{

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = "page4.jsp";

        String firstName1 = request.getParameter("firstName1");
        String lastName1 = request.getParameter("lastName1");

        String firstName2 = request.getParameter("firstName2");
        String lastName2 = request.getParameter("lastName2");

        String firstName3 = request.getParameter("firstName3");
        String lastName3 = request.getParameter("lastName3");

        Studente studente1 = new Studente(firstName1,lastName1);
        Studente studente2 = new Studente(firstName2,lastName2);
        Studente studente3 = new Studente(firstName3,lastName3);

        request.setAttribute("studente1", studente1);
        request.setAttribute("studente2", studente2);
        request.setAttribute("studente3", studente3);

        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);

    }
}
