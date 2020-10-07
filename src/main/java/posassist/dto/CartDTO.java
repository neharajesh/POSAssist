package posassist.dto;

//import java.util.List;

import lombok.Data;
//import posassist.entities.Items;
import posassist.entities.Order;
import posassist.entities.User;

@Data
public class CartDTO {
	private User customerName;
	
	private User staffName;
	
	private Order order;
	
	//private List<Items> itemsList;
	
	private Boolean checkOut;
}
