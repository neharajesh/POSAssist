package posassist.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import posassist.entities.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long>{
	Optional<Items> findByName(String name);
	
	List<Items> findByAvailability(Boolean availability);
}
