package posassist.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import posassist.dto.ItemsDTO;
import posassist.entities.Items;
import posassist.exceptions.ResourceNotFoundException;
import posassist.repositories.ItemsRepository;
import posassist.serviceInterfaces.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public Items findItemById(Long id) {
		Optional<Items> item = itemsRepository.findById(id);
		if(!item.isPresent())
			throw new ResourceNotFoundException("This item is not on the menu tonight!");
		return item.get();
	}

	@Override
	public List<Items> getAllItems() {
		return itemsRepository.findAll();
	}

	@Override
	public Items findItemByName(String itemName) {
		Optional<Items> item = itemsRepository.findByName(itemName);
		if(!item.isPresent())
			throw new ResourceNotFoundException("This item is not on the menu tonight!");
		return item.get();
	}

	@Override
	@Transactional
	public Items saveNewItem(ItemsDTO itemsDTO) {
		Items item = Items.builder()
				.itemName(itemsDTO.getItemName())
				.itemType(itemsDTO.getItemType())
				.price(itemsDTO.getPrice())
				.availability(itemsDTO.getAvailability())
				.build();
		return itemsRepository.save(item);
	}

	@Override
	@Transactional
	public Items updateItem(Long id, ItemsDTO itemsDTO) {
		Items item = findItemById(id);
		item.setItemName(itemsDTO.getItemName());
		item.setItemType(itemsDTO.getItemType());
		item.setPrice(itemsDTO.getPrice());
		item.setAvailability(itemsDTO.getAvailability());
		return itemsRepository.save(item);
	}

	@Override
	public void deleteItem(Long id) {
		Items item = findItemById(id);
		itemsRepository.delete(item);	
	}

	@Override
	public List<Items> findByAvailability(Boolean availabe) {
		return itemsRepository.findByAvailability(availabe);
	}
	
	
}
