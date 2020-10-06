package posassist.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import posassist.enums.ItemType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "items")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String itemName; 
	
	private ItemType itemType;
	
	private Double price;
	
	private Boolean availability;
	
}
