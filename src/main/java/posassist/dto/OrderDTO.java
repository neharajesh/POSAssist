package posassist.dto;

import java.util.Date;

import lombok.Data;
import posassist.enums.OrderType;

@Data
public class OrderDTO {
	private String orderName;
	
	private String orderDetails;
	
	private Date dateOfOrder;
	
	private Double total;
	
	private OrderType orderType;
}
