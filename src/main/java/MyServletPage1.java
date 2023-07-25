import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@WebServlet(urlPatterns = {"/"})
public class MyServletPage1 extends HttpServlet {

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

