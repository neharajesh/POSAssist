package posassist.serviceInterfaces;

import java.util.List;

import posassist.dto.UserDTO;
import posassist.entities.User;
import posassist.exceptions.ResourceNotFoundException;

public interface UserService {
	User findUserById(Long id) throws ResourceNotFoundException;
	
	User findUserByPhoneNo(String phoneno) throws ResourceNotFoundException;
	
	List<User> findAllUsers();
	
	User createUser(UserDTO userDTO);
	
	User updateUserDetails(Long id, UserDTO userDTO);
	
	void deleteUser(Long id);
}
