package posassist.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import posassist.dto.OrderDTO;
import posassist.entities.Order;
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
	public Long saveOrder(OrderDTO orderDTO) {
		return null;
	}

}
