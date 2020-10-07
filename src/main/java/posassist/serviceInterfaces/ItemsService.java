package posassist.serviceInterfaces;

import java.util.List;

import posassist.dto.ItemsDTO;
import posassist.entities.Items;
import posassist.exceptions.ResourceNotFoundException;

public interface ItemsService {
	Items findItemById(Long id) throws ResourceNotFoundException;
	
	List<Items> getAllItems();
	
	Items findItemByName(String itemName) throws ResourceNotFoundException;
	
	List<Items> findByAvailability(Boolean availabe);
	
	Items saveNewItem(ItemsDTO itemsDTO);
	
	Items updateItem(Long id, ItemsDTO itemsDTO);
	
	void deleteItem(Long id);
}
