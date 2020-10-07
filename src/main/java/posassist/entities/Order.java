package posassist.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import posassist.enums.OrderType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String orderName;
	
	private String orderDetails;
	
	@Enumerated(EnumType.STRING)
	private OrderType orderType;
	
	@OneToMany
	private Set<OrderItems> orderitems = new HashSet<OrderItems>();
	
	private Date dateOfOrder;
	
	private Double total;
	
	
}
