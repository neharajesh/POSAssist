package posassist.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import posassist.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findUserById(Long id);
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByPhoneNo(String phoneNo);
	
	Boolean checkUserExistsByEmail(String email);
	
	Boolean checkUserExistsByPhoneno(String phoneno);
	
}
