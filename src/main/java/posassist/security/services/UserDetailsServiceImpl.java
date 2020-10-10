package posassist.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import posassist.entities.User;
import posassist.exceptions.ResourceNotFoundException;
import posassist.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email)
		throws ResourceNotFoundException {

	        User user = userRepository.findByEmail(email)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException("User Not Found with ->  email : " + email)
	                );

	        return UserPrinciple.build(user);
	}
}
