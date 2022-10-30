package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
	
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	/**
	 * Create a new public method in the OrdersRestService class named
getOrdersAsJson() that returns a List of OrderModel and is marked with the
@GetMapping annotation with the path attribute set to a value of /getjson and the
produces attribute set to a value of MediaType.APPLICATION_JSON_VALUE.
The MediaType should be imported from the
org.springframework.http.MediaType package. The method should call the
getOrders() method implementation and return the value on the service variable.
	 * @return
	 */
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})	
	public List<OrderModel> getOrdersAsJson(){
		return service.getOrders();
	}
	
	/**
	 * Create a new public method in the OrdersRestService class named
getOrdersAsXml() that returns a OrderList and is marked with the @GetMapping
annotation with the path attribute set to a value of /getxml and the produces
attribute set to a value of MediaType.APPLICATION_XML_VALUE. The
MediaType should be imported from the org.springframework.http.MediaType
package. The method implementation should create an instance of an OrderList,
call the setOrders() method with the return value of the getOrders() method on
the service variable, and return the instance of the OrderList.

	 * @return
	 */
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_ATOM_XML_VALUE})
	public OrderList getOrdersAsXml() {
		OrderList ol = new OrderList();
		ol.setOrders(service.getOrders());
		return ol;
	}
}
