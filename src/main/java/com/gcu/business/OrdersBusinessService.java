package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	/**
	 * Gets the orders.
	 *
	 * @return the orders
	 */
	@Override
	public List<OrderModel> getOrders() {
		//create some orders
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "0000000001", "Order Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "0000000002", "Order Product 2", 2.00f, 2));
		orders.add(new OrderModel(2L, "0000000003", "Order Product 3", 3.00f, 3));
		orders.add(new OrderModel(3L, "0000000004", "Order Product 4", 4.00f, 4));
		orders.add(new OrderModel(4L, "0000000005", "Order Product 5", 5.00f, 5));
			
		return orders;
}

	@Override
	public void init() {
		System.out.println("init");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
