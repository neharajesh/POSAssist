package posassist.serviceInterfaces;

import java.util.List;

import posassist.dto.CartDTO;
import posassist.entities.Cart;
import posassist.exceptions.ResourceNotFoundException;

public interface CartService {
	Cart saveCart(CartDTO cartDTO);
	
	Cart findCartById(Long id) throws ResourceNotFoundException;
	
	Cart findCartByCustomer(String customerName) throws ResourceNotFoundException;
	
	Cart findCartByStaff(String staffName) throws ResourceNotFoundException;
	
	List<Cart> findAllCartOrders();
	
	Cart updateCartDetails(Long id, CartDTO cartDTO);
	
	void deleteCart(Long id);
}
