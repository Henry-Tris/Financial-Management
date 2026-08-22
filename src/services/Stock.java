package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entities.Product;

public class Stock {

	private Map<String, Product> products;

	public Stock() {
		this.products = new HashMap<>();
	}
	
	public void addProduct(Product product) {
		if (products.containsKey(product.getName())) {
            Product existing = products.get(product.getName());
            existing.setQuantity(existing.getQuantity() + product.getQuantity());
            existing.setCostPrice(product.getCostPrice());
        } else {
            products.put(product.getName(), product);
        }
	}
	
	public void removeProduct(String name) {
		products.remove(name);
	}
	
	public Product findProduct(String name) {
        return products.get(name);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
}
