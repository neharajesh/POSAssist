package posassist.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import posassist.serviceInterfaces.OrderService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping(OrderController.BASE_URL)
public class OrderController {
	public static final String BASE_URL = "/v1/order";
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/get")
	public @ResponseBody ResponseEntity<?> get() {
		return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Long id) {
		return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
	}
	
	@GetMapping("/get/{date}")
	public @ResponseBody ResponseEntity<?> getByDate(@PathVariable Date date) {
		return new ResponseEntity<>(orderService.findOrderByDate(date), HttpStatus.OK);
	}
}
