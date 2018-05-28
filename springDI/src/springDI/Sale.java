package springDI;

import java.util.UUID;

public class Sale {
	private final UUID id;
	private final UUID productID;
	private final UUID customerID;
	private final int quantity;
	private double price;
	
	public Sale(Builder builder) {
		this.id = UUID.randomUUID();
		this.productID =builder.productID;
		this.customerID = builder.customerID;
		this.quantity = builder.quantity;
		this.price = builder.price;
	}

	public UUID getId() {
		return id;
	}
	public UUID getProductID() {
		return productID;
	}
	public UUID getCustomerID() {
		return customerID;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder{
		private UUID productID;
		private UUID customerID;
		private int quantity;
		private double price;
		
		public Builder withProductId(UUID productID){
			this.productID = productID;
			return this;
		}
		public Builder withCustomerId(UUID customerID){
			this.customerID = customerID;
			return this;
		}
		public Builder withQuantity(int quantity){
			this.quantity = quantity;
			return this;
		}
		public Builder withPrice(double price){
			this.price = price;
			return this;
		}
		
		public Sale build(){
			return new Sale(this);
		}
		
	}
	
}
