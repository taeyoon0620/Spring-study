package himedia.spring.ver3.controller;

import java.util.List;
import java.util.Optional;

import himedia.spring.ver3.dto.Item;

public interface ItemRepository {
	
	void save(Item item);
	Optional<Item> findById(Long id);
	// id를 인수로 검색, null이 반환될 수 있기 때문에 Optional을 사용 (null에 관한 처리 -> Optional 사용)
	Optional<Item> findByName(String name);
	List<Item> findAll();
	Item update(Long itemId, Item updateItem);
	// save는 insert 한 row의 개수 return, update는 수정한 row의 개수 return

    public List<Item> findByName(String name) {
        return itemRepository.findByNameContaining(name);
    }
}
