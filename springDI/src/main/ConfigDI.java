package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springDI.Customer;
import springDI.Product;
import springDI.Sale;

@Configuration
@ComponentScan(value = { "springDI.*" })
public class ConfigDI {
	@Bean
	public Product product() {
		return new Product("Phone", 20);
	}

	@Bean
	public Product otherProduct() {
		return new Product("Laptop", 15);
	}

	@Bean
	public Customer customer() {
		return new Customer("Andrei", "Vasile");
	}

	@Bean
	public Customer otherCustomer() {
		return new Customer("Ion", "Ion");
	}

	@Bean
	public Sale sale1() {
		return Sale.builder().withCustomerId(customer().getId()).withProductId(product().getId())
				.withPrice(product().getPrice()).withQuantity(7).build();
	}

	@Bean
	public Sale sale2() {
		return Sale.builder()
				.withCustomerId(otherCustomer().getId())
				.withProductId(otherProduct().getId())
				.withPrice(otherProduct().getPrice())
				.withQuantity(8)
				.build();
	}
}
