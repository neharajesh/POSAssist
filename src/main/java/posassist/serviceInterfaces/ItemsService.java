package posassist.serviceInterfaces;

import java.util.List;

import posassist.entities.Items;

public interface ItemsService {
	Items findItemById(Long id);
	
	List<Items> getAllItems();
	
	Items findItemByName(String itemName);
}
