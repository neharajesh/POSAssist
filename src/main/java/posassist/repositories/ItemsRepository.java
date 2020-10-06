package posassist.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import posassist.entities.Items;

public interface ItemsRepository extends JpaRepository<Items, Long>{
	Optional<Items> findByName(String name);
}
