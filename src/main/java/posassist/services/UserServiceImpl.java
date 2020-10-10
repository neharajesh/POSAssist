package posassist.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import posassist.dto.UserDTO;
import posassist.entities.Role;
import posassist.entities.User;
import posassist.enums.UserType;
import posassist.exceptions.BadRequestException;
import posassist.exceptions.ResourceNotFoundException;
import posassist.repositories.RoleRepository;
import posassist.repositories.UserRepository;
import posassist.serviceInterfaces.UserService;

@Service
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
	@Transactional
	public User createUser(UserDTO userDTO) {
		if(userRepository.checkUserExistsByEmail(userDTO.getEmailId())) 
			throw new BadRequestException("This email id has been taken! ");
		
		//Creating a new account.
		User user = User.builder()
				.name(userDTO.getName())
				.emailId(userDTO.getEmailId())
				.password(passwordEncoder.encode(userDTO.getPassword()))
				.phoneNo(userDTO.getPhoneNo())
				.address(userDTO.getAddress())	
				.build();
		
		Set<String> strRole = userDTO.getRole();
		Set<Role> role = new HashSet<Role>();
		
		strRole.forEach(roleType -> {
			switch(roleType) {
			case "ADMIN" :
				Role adminRole = roleRepository.findRoleByName(UserType.ADMIN)
					.orElseThrow(() -> new RuntimeException("Role not found! "));
				role.add(adminRole);
				break;
				
			case "CUSTOMER":
				Role customerRole = roleRepository.findRoleByName(UserType.CUSTOMER)
					.orElseThrow(() -> new RuntimeException("Role not found."));
				role.add(customerRole);
				break;
			
			case "STAFF" :
				Role staffRole = roleRepository.findRoleByName(UserType.STAFF)
					.orElseThrow(() -> new RuntimeException("Role not found"));
				role.add(staffRole);
				break;
				
			case "DELIVERY" :
				Role deliveryRole = roleRepository.findRoleByName(UserType.DELIVERY)
					.orElseThrow(() -> new RuntimeException("Role not found"));
				role.add(deliveryRole);
				break;
			}
		});
		user.setRole(role);
		
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public User updateUserDetails(Long id, UserDTO userDTO) {
		User user = User.builder()
				.name(userDTO.getName())
				.emailId(userDTO.getEmailId())
				.address(userDTO.getAddress())
				.phoneNo(userDTO.getPhoneNo())
				.password(passwordEncoder.encode(userDTO.getPassword()))
				.build();
		return userRepository.save(user);
		
	}

	@Override
	public void deleteUser(Long id) {
		User user = findUserById(id);
		userRepository.delete(user);
		
	}

}
