package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springDI.Customer;
import springDI.Product;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigDI.class);
		Customer c = context.getBean(Customer.class);
		System.out.println(c.getFirstName());
		context.close();
	}

}
