import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/shopPage3"})
public class MyServletPage3 extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = req.getParameter("Entered name");
        StringBuilder orderAsString = new StringBuilder();
        Double totalPrice = 0.0;
        int i = 1;
        String[] products = req.getParameterValues("selectedProducts");

        Map<String, Double> productsMap = new HashMap<String, Double>();
        productsMap.put("Book", 5.0);
        productsMap.put("Pen", 1.1);
        productsMap.put("Pencil", 3.3);
        productsMap.put("Copybook", 2.2);

        for (String product : products) {
            if (!productsMap.containsKey(products)) {
                orderAsString.append(String.format("No such product", product));
                continue;
            }
            totalPrice += productsMap.get(product);
            orderAsString.append(String.format("%d) %s %.1f $ <br>", i++, product, productsMap.get(product)));
        }

        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>ShopPage3</title>\n" +
                "    <style> body{text-align: center;} </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Dear" + userName, + "your order:</h1>\n" +
                orderAsString + "\n" +
                "<h2>Total:</h2>" + totalPrice + " $: \n" +
                "</body>\n" +
                "</html>");
    }
}