package springDI;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

public class Store {
	private List<Product> products;
	private List<Customer> customers;
	private List<Sale> sales;
	
	private static Function<List<Customer>, Function<Sale, String>> GET_CUSTOMER = list -> sale -> list.stream()
			.filter(cust -> cust.getId().equals(sale.getCustomerID())).findFirst().get().toString();
	@Autowired
	public Store(List<Product> products, List<Customer> customers) {
		this.customers = customers;
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void sale(Product p, Customer c, int quantity, double price) throws IllegalArgumentException {
		if (p == null || c == null || quantity < 1) {
			throw new IllegalArgumentException("invalid parameters");
		}

		Sale s = Sale.builder()
				.withProductId(p.getId())
				.withCustomerId(c.getId())
				.withQuantity(quantity)
				.withPrice(price)
				.build();
		sales.add(s);
	}
	
	public void cancelSale(UUID id){
		sales.removeIf(s -> s.getId().equals(id));
	}
}
