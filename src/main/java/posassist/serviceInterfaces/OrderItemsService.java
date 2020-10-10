package posassist.serviceInterfaces;

import java.util.List;

import posassist.dto.OrderItemsDTO;
import posassist.entities.OrderItems;

public interface OrderItemsService {
	List<OrderItems> findAllOrderItems();
	
	OrderItems addItemToOrder(OrderItemsDTO orderItemsDTO);
	
	OrderItems findOrderItemsById(Long id);
	
	OrderItems updateOrderItems(Long id, OrderItemsDTO orderItemsDTO);
	
	void deleteOrderItems(Long id);
}
