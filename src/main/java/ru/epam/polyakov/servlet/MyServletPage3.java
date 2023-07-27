package ru.epam.polyakov.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.epam.polyakov.entity.ProductInfo;
import ru.epam.polyakov.view.SimpleView;

@WebServlet(urlPatterns = { "/shopPage3" })
public class MyServletPage3 extends HttpServlet {
	private static final long serialVersionUID = 5503069836581248751L;

	private static final String TEMPLATE_PATH = "informationToTheServerFromPage3.html";
	
	private SimpleView simpleView;
	private ProductInfo productInfo;

	@Override
	public void init() throws ServletException {
		super.init();
		simpleView = new SimpleView();
		productInfo = new ProductInfo();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		@SuppressWarnings("unchecked")
		List<String> sessionProducts = (List<String>) session.getAttribute("products");
		String[] products = request.getParameterValues("setOfTheProducts");

		if (products != null && products.length > 0) {

			for (int i = 0; i < products.length; i++) {
				sessionProducts.add(products[i]);
			}
		}

		Map<String, Long> productsQuantity = sessionProducts.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<String> productsResult = new ArrayList<>();
		Double totalPrice = 0.0;

		for (Map.Entry<String, Long> productQuantity : productsQuantity.entrySet()) {

			if (productInfo.getProductNames().stream().anyMatch(p -> p.equals(productQuantity.getKey()))) {

				String productName = productQuantity.getKey();
				Long productUnit = productQuantity.getValue();
				double productPrice = productInfo.getProductPrice(productQuantity.getKey());

				productsResult.add(productName + " | " + productUnit + " units | " + productPrice + " \\$");
				totalPrice += productUnit * productPrice;
			}
		}
		
		simpleView.setWriter(response.getWriter());
        String resultHtml = simpleView.openHtmlTemplate(TEMPLATE_PATH);
        resultHtml = simpleView.addSimpleTextToTemplate(resultHtml, userName, String.format("%.2f \\$", totalPrice));
        resultHtml = simpleView.addListTextToTemplate(resultHtml, productsResult.toArray());
        
        simpleView.render(resultHtml);

		session.removeAttribute("products");
		session.invalidate();
	}
}