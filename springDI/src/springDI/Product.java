package springDI;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private final UUID id;
	private final String description;
	private final double price;
	public UUID getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public Product(String description, double price) {
		this.id = UUID.randomUUID();
		this.description = description;
		this.price = price;
	}
}
