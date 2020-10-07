package posassist.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import posassist.entities.Items;
import posassist.entities.OrderItems;
import posassist.enums.OrderType;

@Data
public class OrderDTO {
	private String orderName;
	
	private String orderDetails;
	
	private Date dateOfOrder;
	
	private Double total;
	
	private OrderType orderType;
	
	private Set<OrderItems> orderItems = new HashSet<OrderItems>();
}
