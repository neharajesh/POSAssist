package posassist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import posassist.entities.Items;

public interface ItemsRepository extends JpaRepository<Items, Long>{

}
