package posassist.dto;

import lombok.Data;
import posassist.enums.ItemType;

@Data
public class ItemsDTO {
	private String itemName;
	
	private ItemType itemType;
	
	private Double price;
	
	private Boolean availability;
	
}
