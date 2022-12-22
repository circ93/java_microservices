package it.course.servletexample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletError", value = "/servlet-error")
public class ServletError extends HelloServlet{

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String msg = "Ricompila il form, i dati inseriti non sono presenti nel DB";
        request.setAttribute("msg", msg);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

}
