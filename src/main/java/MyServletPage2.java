import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = {"/shopPage2"})
public class MyServletPage2 extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        StringBuilder orderAsString = new StringBuilder();

        Map<String, Double> productsMap = new HashMap<String, Double>();
        productsMap.put("Book", 5.5);
        productsMap.put("Pen", 1.1);
        productsMap.put("Pencil", 3.3);
        productsMap.put("Copybook", 2.2);

        String products = request.getParameter("setOfTheProducts");
        session.setAttribute("products",orderAsString);
        String userName = request.getParameter("userName");
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
                "<form action=\"shopPage3\" method=\"POST\">\n" +
                "    <select name=\"setOfTheProducts\" multiple>\n" +
                "        <option value=\"Book\">Book (5,5$)</option>\n" +
                "        <option value=\"Pen\">Pen (1,1$)</option>\n" +
                "        <option value=\"Pencil\">Pencil (3,3$)</option>\n" +
                "        <option value=\"Copybook\">Copybook (2,2$)</option>\n" +
                "    </select>\n" +
                "    <br>\n" +
                "    <input type=\"text\" name=\"userName\" value = \"" + userName + "\" hidden>\n" +
                "    <br>\n" +
                "<button formaction=\"shopPage2\">Add Item</button>\n"+
                "     <input type=\"submit\" value=\"ENTER\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
