package it.course.servletexample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletStud", value = "/servlet_stud")
public class ServletStud extends HelloServlet{

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = "page4.jsp";

        int lenParam = request.getParameterValues("firstName").length;

        if (lenParam > 0){

            String[] name = request.getParameterValues("firstName");
            String[] last = request.getParameterValues("lastName");
            Studente studente;
            List<Studente> stud = new ArrayList<>();

            for (int i=0; i<lenParam; i++){

                studente = new Studente(name[i], last[i]);
                stud.add(studente);
            }

            request.setAttribute("student", stud);

        }

        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);

    }
}
