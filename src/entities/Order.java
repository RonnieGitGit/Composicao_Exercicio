package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	private List<OrderItem> orderItens = new ArrayList<OrderItem>();
	private OrderStatus status;
	private Date moment;
	private Client client;

	public Order() {

	}

	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
		this.moment = new Date();
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem orderItem) {
		orderItens.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {
		orderItens.remove(orderItem);
	}

	public Double total() {
		Double sum = 0.0;
		for (OrderItem o : orderItens) {
			sum += o.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sp.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : orderItens) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));

		return sb.toString();
	}

}
