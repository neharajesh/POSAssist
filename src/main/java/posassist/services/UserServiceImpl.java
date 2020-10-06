package posassist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;

import posassist.dto.UserDTO;
import posassist.entities.User;
import posassist.exceptions.ResourceNotFoundException;
import posassist.repositories.RoleRepository;
import posassist.repositories.UserRepository;
import posassist.serviceInterfaces.UserService;

public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	@Override
	public User findUserById(Long id) throws ResourceNotFoundException{
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new ResourceNotFoundException("This user does not exist! ");
		return user.get();
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByPhoneNo(String phoneno) throws ResourceNotFoundException {
		Optional<User> user = userRepository.findByPhoneNo(phoneno);
		if(!user.isPresent())
			throw new ResourceNotFoundException("This user does not exist! ");
		return user.get();
	}

	@Override
	public User createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
