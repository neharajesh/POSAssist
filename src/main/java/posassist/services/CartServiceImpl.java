package posassist.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import posassist.dto.CartDTO;
import posassist.entities.Cart;
import posassist.exceptions.ResourceNotFoundException;
import posassist.repositories.CartRepository;
import posassist.serviceInterfaces.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart saveCart(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart findCartById(Long id) throws ResourceNotFoundException {
		Optional<Cart> cart = cartRepository.findById(id);
		if(!cart.isPresent())
			throw new ResourceNotFoundException("This cart/table order does not exist");
		return cart.get();
	}

	@Override
	public Cart findCartByCustomer(String customerName) throws ResourceNotFoundException {
		Optional<Cart> cart = cartRepository.findByCustomerName(customerName);
		if(!cart.isPresent())
			throw new ResourceNotFoundException("Cart with customer name not found");
		return cart.get();
	}

	@Override
	public Cart findCartByStaff(String staffName) throws ResourceNotFoundException {
		Optional<Cart> cart = cartRepository.findByStaffName(staffName);
		if(!cart.isPresent())
			throw new ResourceNotFoundException("Cart with customer name not found");
		return cart.get();
	}

	@Override
	public List<Cart> findAllCartOrders() {
		return cartRepository.findAll();
	}

	@Override
	@Transactional
	public Cart updateCartDetails(Long id, CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCart(Long id) {
		cartRepository.delete(findCartById(id));
		
	}

}
