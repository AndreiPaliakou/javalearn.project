package ru.epam.polyakov.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductInfo {
	private List<String> products;
	
	public ProductInfo() {
		products = new ArrayList<>() {
			
			private static final long serialVersionUID = 5148782375045511379L;

		{
			add("Book (5.5$)");
			add("Pen (1.1$)");
			add("Pencil (3.3$)");
			add("Copybook (2.2$)");
		}};
	}
	
	public List<String> getProductNames() {
		return products.stream().map(p -> p.split(" ")[0]).toList();
	}
	
	/***
	 * 
	 * Get product price on product name
	 * 
	 * @param productName product name
	 * @return double product price
	 * @throws NoSuchElementException when product name not found
	 */
	public double getProductPrice(String productName) {
		
		String productResult = products.stream()
				                       .filter(product -> product.split(" ")[0].equals(productName))
				                       .findFirst()
				                       .orElseThrow(() -> new NoSuchElementException());
		
		String priceVal = productResult.split(" ")[1];
		
		return Double.valueOf(priceVal.substring(1, priceVal.length() - 2));
	}
	
}
