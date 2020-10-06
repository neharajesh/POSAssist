package posassist.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import posassist.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	Optional<Order> findByDate(Date orderDate);
	
}
