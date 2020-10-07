package posassist.dto;

import lombok.Data;
import posassist.entities.Items;

@Data
public class OrderItemsDTO {
	private Items items;
	
	private String instructions;
	
	private Integer quantity;
}
