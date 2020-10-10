package posassist.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import posassist.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	Optional<Cart> findByCustomerName(String customerName);
	
	Optional<Cart> findByStaffName(String staffName);
}
