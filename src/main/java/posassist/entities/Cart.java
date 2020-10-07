package posassist.entities;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinTable(name = "users", 
				joinColumns = @JoinColumn(name = "users_name"))
	private User customerName;
	
	@ManyToOne
	@JoinTable(name = "users", 
				joinColumns = @JoinColumn(name = "users_name"))
	private User staffName;
	
	@OneToOne
	@JoinTable(name = "order", 
				joinColumns = @JoinColumn(name = "order_id"))
	private Order order;
	
	//private List<Items> itemsList = new ArrayList<Items>();
	
	private Boolean checkOut;
}
