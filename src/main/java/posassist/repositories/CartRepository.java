package posassist.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import posassist.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	Optional<Cart> findByCustomerName(String customerName);
	
	Optional<Cart> findByStaffName(String staffName);
}
