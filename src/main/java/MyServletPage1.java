import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;


@WebServlet(urlPatterns = {"/"})
public class MyServletPage1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] result = new byte[64 * 1024];

        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("informationToTheServerFromPage1.html")) {
            stream.read(result);

            String resultAsString = new String(result, Charset.forName("UTF-8"));

            response.getWriter().print(resultAsString);
        }
    }
}
