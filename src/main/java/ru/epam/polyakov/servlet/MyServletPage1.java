package ru.epam.polyakov.servlet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/"})
public class MyServletPage1 extends HttpServlet {
	private static final long serialVersionUID = 2501318350481995851L;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] result = new byte[64 * 1024];

        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("informationToTheServerFromPage1.html")) {
            assert stream != null;
            stream.read(result);
            String resultAsString = new String(result, StandardCharsets.UTF_8);
            response.getWriter().print(resultAsString);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkBox = request.getParameter("nameOfChoice");
        if (checkBox != null && checkBox.equals("on")) {
            RequestDispatcher rd = request.getRequestDispatcher("/shopPage2");
            rd.forward(request, response);
        } else {
            byte[] result = new byte[64 * 1024];
            try (InputStream stream = getClass().getClassLoader().getResourceAsStream("agreementCheckingError.html")) {
                stream.read(result);
                String resultAsString = new String(result, StandardCharsets.UTF_8);
                response.getWriter().print(resultAsString);
            }

        }
    }
}

