import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/"})
public class MyServletPage1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>ShopPage1</title>\n" +
                "    <style> body{text-align: center;} </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Welcome to Online Shop!!!</h1>\n" +
                "<form action=\"/shopPage2\" method=\"POST\">\n" +
                "    <input type=\"text\" userName=\"Entered name\" Enter your name></input>\n" +
                "    <br><br>\n" +
                "    <button formNoValidate type=\"Press the button\"> Enter</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
