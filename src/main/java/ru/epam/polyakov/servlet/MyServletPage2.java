package ru.epam.polyakov.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.epam.polyakov.view.SimpleView;


@WebServlet(urlPatterns = {"/shopPage2"})
public class MyServletPage2 extends HttpServlet {
	private static final long serialVersionUID = -7719867281317627903L;

	private static final String TEMPLATE_PATH = "informationToTheServerFromPage2.html";
	
	private SimpleView simpleView;
	
	@Override
    public void init() throws ServletException {
    	super.init();
    	simpleView = new SimpleView();
    }
	
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String userName = request.getParameter("userName");
    	String[] products = request.getParameterValues("setOfTheProducts");    	
    	HttpSession session = request.getSession();
    	
    	if (session.isNew()) {
    		session.setAttribute("products", new ArrayList<>());
    	}
    	
    	@SuppressWarnings("unchecked")
		List<String> sessionProducts = (List<String>)session.getAttribute("products");
    	
    	if (products != null && products.length > 0) {
    		
    		for (int i = 0; i < products.length; i++) {
    			sessionProducts.add(products[i]);
    		}
    	}       
        
        simpleView.setWriter(response.getWriter());
        String resultHtml = simpleView.openHtmlTemplate(TEMPLATE_PATH);
        resultHtml = simpleView.addSimpleTextToTemplate(resultHtml, userName, userName);        
        resultHtml = simpleView.addListTextToTemplate(resultHtml, sessionProducts.toArray());
       
        simpleView.render(resultHtml);
    }
        
}
