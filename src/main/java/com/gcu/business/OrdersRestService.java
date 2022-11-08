package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * Update the OrdersRestService class by adding a new API named getOrder() that is
mapped to the /getorder/{id} path and will be used to get an order (i.e., OrderModel)
given an id as a parameter in the URI. The API should mapped to a GET request. The
OrderModel should be obtained by calling the findById() method of service variable. The
API should return an instance of a ResponseEntity. Set the ResponseEntity status to
HttpStatus.NOT_FOUND if the return from the service call is null. If the service call
returns a non-null value, set the ResponseEntity status to HttpStatus.OK and set the return
entity to the value returned from the service call. Put a try catch block around all the logic
and set the  ResponseEntity status to HttpStatus.INTERNAL_SERVER_ERROR in the
catch block.
	 */
	@GetMapping(path="/getorder/{id}")
	public ResponseEntity<?> getOrder(@PathVariable("id")String id){
		try{
			OrderModel order = service.getOrdersById(id);
			if(order == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else return new ResponseEntity<>(order, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
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
