package posassist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import posassist.entities.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long>{

}
