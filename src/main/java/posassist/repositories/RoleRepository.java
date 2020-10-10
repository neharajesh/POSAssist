package posassist.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import posassist.entities.Role;
import posassist.enums.UserType;
import posassist.exceptions.ResourceNotFoundException;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findRoleById(Long id) throws ResourceNotFoundException;
	
	Optional<Role> findRoleByName(UserType role);
}
