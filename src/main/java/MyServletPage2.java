import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/shopPage2"})
public class MyServletPage2 extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("Entered name");
        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>ShopPage2</title>\n" +
                "    <style> body{text-align: center;} </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Hello" + userName + "!</h1>\n" +
                "<h2>Make your order:</h2>\n" +
                "<br>\n" +
                "<form action=\"/shopPage3\" method=\"POST\">\n" +
                "    <select products=\"setOfTheProducts\" selectAnyoneProducts>\n" +
                "        <option value=\"Book\">Book (5,5$)</option>\n" +
                "        <option value=\"Pen\">Pen (1,1$)</option>\n" +
                "        <option value=\"Pencil\">Pencil (3,3$)</option>\n" +
                "        <option value=\"Copybook\">Copybook (2,2$)</option>\n" +
                "    </select>\n" +
                "    <br>\n" +
                "    <input type=\"text\" selectedProducts=\"selectedProducts\" value></input>\n" +
                "    <br>\n" +
                "    <button formNoValidate type=\"Submit\" Press the button></button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
