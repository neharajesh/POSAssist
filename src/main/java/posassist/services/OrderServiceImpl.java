package posassist.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import posassist.dto.OrderDTO;
import posassist.entities.Order;
import posassist.enums.OrderType;
import posassist.exceptions.ResourceNotFoundException;
import posassist.repositories.OrderRepository;
import posassist.serviceInterfaces.ItemsService;
import posassist.serviceInterfaces.OrderService;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ItemsService itemService;
	
	@Override
	public Order findOrderById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if(!order.isPresent()) 
			throw new ResourceNotFoundException("Order not found!");
		return order.get();
	}

	@Override
	public Order findOrderByDate(Date date) {
		Optional<Order> order = orderRepository.findByDate(date);
		if(!order.isPresent()) 
			throw new ResourceNotFoundException("Order not found!");
		return order.get();
	}

	@Override
	@Transactional
	public Order saveOrder(OrderDTO orderDTO) {
		//add stuff to the order. 
		//stuff from the cart that is.
		
		Order order = Order.builder()
				.orderName("OrderName")	//change value
				.orderDetails("OrderDetails")	//change value
				.dateOfOrder(new Date())
				.total(0.0)	//change value
				.orderType(OrderType.TRIAL)	//change value
				.build();
		
		return orderRepository.save(order);
	}

	@Override
	@Transactional
	public Order updateOrder(Long id, OrderDTO orderDTO) {
		Order order = findOrderById(id);
		order.setOrderName(orderDTO.getOrderName());
		order.setOrderType(orderDTO.getOrderType());
		order.setTotal(orderDTO.getTotal());
		order.setOrderDetails(orderDTO.getOrderDetails());
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.delete(findOrderById(id));
		
	}

}
