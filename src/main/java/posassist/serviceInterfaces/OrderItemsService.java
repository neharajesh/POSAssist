package posassist.serviceInterfaces;

import posassist.dto.OrderItemsDTO;
import posassist.entities.OrderItems;

public interface OrderItemsService {
	OrderItems addItemToOrder(OrderItemsDTO orderItemsDTO);
	
	OrderItems findOrderItemsById(Long id);
	
	OrderItems updateOrderItems(Long id, OrderItemsDTO orderItemsDTO);
	
	void deleteOrderItems(Long id);
}
