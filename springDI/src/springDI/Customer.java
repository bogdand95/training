package springDI;

import java.util.UUID;

import org.springframework.stereotype.Component;
@Component
public class Customer {
	private final UUID id;
	private final String firstName;
	private final String lastName;
	public UUID getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Customer(String firstName, String lastName) {
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString(){
		return this.firstName + " " +this.lastName;
	}
}
