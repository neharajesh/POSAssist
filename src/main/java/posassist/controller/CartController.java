package posassist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import posassist.dto.CartDTO;
import posassist.serviceInterfaces.CartService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping(CartController.BASE_URL)
public class CartController {
	public static final String BASE_URL = "/v1/cart";
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/get")
	public @ResponseBody ResponseEntity<?> getAll() {
		return new ResponseEntity<>(cartService.findAllCartOrders(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Long id) {
		return new ResponseEntity<>(cartService.findCartById(id), HttpStatus.OK);
	}
	
	@GetMapping("/get/{customerName}")
	public @ResponseBody ResponseEntity<?> getByCustomerName(@PathVariable String customerName) {
		return new ResponseEntity<>(cartService.findCartByCustomer(customerName), HttpStatus.OK);
	}
	
	@GetMapping("/get/{staffName}")
	public @ResponseBody ResponseEntity<?> getByStaffName(@PathVariable String staffName) {
		return new ResponseEntity<>(cartService.findCartByStaff(staffName), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<?> saveCart(@RequestBody CartDTO cartDTO) {
		return new ResponseEntity<>(cartService.saveCart(cartDTO), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public @ResponseBody ResponseEntity<?> updateCart(@PathVariable Long id, @RequestBody CartDTO cartDTO) {
		return new ResponseEntity<>(cartService.updateCartDetails(id, cartDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody ResponseEntity<?> deleteCart(@PathVariable Long id) {
		cartService.deleteCart(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
