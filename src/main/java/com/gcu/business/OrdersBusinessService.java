package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;


public class OrdersBusinessService<T> implements OrdersBusinessServiceInterface {

	@SuppressWarnings("rawtypes")
	@Autowired
	OrdersDataService service;
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	/**
	 * Gets the orders.
	 *
	 * @return the orders
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderModel> getOrders() {
		//get all entity orders
		List<OrderEntity> ordersEntity = service.findAll();
		
		//iterate over the entity orders and create a list of domain orders
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		
		/**
		 * Iterate over the ordersEntity List and create a new instance of OrderModel from
the OrderEntity objects and add the instances of the OrderModel to the or
ordersDomain List. This is required so the persistence technology dependencies
from the OrderEntity do not get propagated to the presentation layer.
		 */
		for(OrderEntity entity : ordersEntity) {
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(),
					entity.getPrice(), entity.getQuantity()));
		}
		return ordersDomain;
}

	@Override
	public void init() {
		System.out.println("init");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public OrderModel getOrdersById(String id) {
//		//get the entity order
		OrderEntity order = (OrderEntity) service.findById(id);
//		 
//		//convert entity order to domain order
		 return new OrderModel(order.getId(), order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());

		//can just do this instead if we change the return type in OrdersBusinessServiceInterface.java and getOrder type in OrdersRestService.java
//		OrderEntity order = (OrderEntity) service.findById(id);
//		 return order;
		 
		 
		 
	}

}
