package posassist.serviceInterfaces;

import java.util.Date;

import posassist.dto.OrderDTO;
import posassist.entities.Order;

public interface OrderService {
	Order findOrderById(Long id);
	
	Order findOrderByDate(Date date);
	
	Order saveOrder(OrderDTO orderDTO);
	
	Order updateOrder(Long id, OrderDTO orderDTO);
	
	void deleteOrder(Long id);
	
}
