package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner tc = new Scanner(System.in);
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter client data:");
		System.out.print("\nName: ");
		String nameClient = tc.nextLine();
		System.out.print("E-mail: ");
		String email = tc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sp.parse(tc.next());
		Client client = new Client(nameClient, email, birthDate);
		
		System.out.print("\nEnter order data:");
		System.out.print("\nStatus: ");
		tc.nextLine();
		String status = tc.nextLine();
		Order order = new Order(OrderStatus.valueOf(status), client);
		System.out.print("How many items to this order? ");
		Integer n = tc.nextInt();
		tc.nextLine();
		
		for (int count=1; count <=n; count++ ) {
			System.out.print("Enter #" + count + " item data: ");
			System.out.print("\nProduct name: ");
			String name = tc.nextLine();
			System.out.print("Product price: ");
			Double price = tc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = tc.nextInt();
			tc.nextLine();
			
			Product product = new Product(name, price);
			
			OrderItem orderItem = new OrderItem(product, quantity, price);
			
			order.addItem(orderItem);
			
		}
		
		System.out.print(order.toString());
		tc.close();
		
	}

}
