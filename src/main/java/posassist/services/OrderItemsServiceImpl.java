package posassist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import posassist.dto.OrderItemsDTO;
import posassist.entities.OrderItems;
import posassist.exceptions.ResourceNotFoundException;
import posassist.repositories.OrderItemsRepository;
import posassist.serviceInterfaces.OrderItemsService;

public class OrderItemsServiceImpl implements OrderItemsService{
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@Override
	public OrderItems addItemToOrder(OrderItemsDTO orderItemsDTO) {
		OrderItems orderItems = OrderItems.builder()
				.quantity(orderItemsDTO.getQuantity())
				.instructions(orderItemsDTO.getInstructions())
				.item(orderItemsDTO.getItems())
				.build();
		
		return orderItemsRepository.save(orderItems);
	}

	@Override
	public OrderItems findOrderItemsById(Long id) {
		Optional<OrderItems> orderItems = orderItemsRepository.findById(id);
		if(!orderItems.isPresent())
			throw new ResourceNotFoundException("Item not found in order");
		return orderItems.get();
	}

	@Override
	public OrderItems updateOrderItems(Long id, OrderItemsDTO orderItemsDTO) {
		OrderItems orderItems = findOrderItemsById(id);
		orderItems.setInstructions(orderItems.getInstructions());
		orderItems.setQuantity(orderItems.getQuantity());
		orderItems.setItem(orderItems.getItem());
		return orderItemsRepository.save(orderItems);
	}

	@Override
	public void deleteOrderItems(Long id) {
		orderItemsRepository.delete(findOrderItemsById(id));
	}

}
