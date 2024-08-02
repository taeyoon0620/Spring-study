package himedia.spring.ver3.controller;

import java.util.List;
import java.util.Optional;

import himedia.spring.ver3.dto.Item;

public interface ItemRepository {
	
	void save(Item item);
	Optional<Item> findById(Long id);
	// id�� �μ��� �˻�, null�� ��ȯ�� �� �ֱ� ������ Optional�� ��� (null�� ���� ó�� -> Optional ���)
	Optional<Item> findByName(String name);
	List<Item> findAll();
	Item update(Long itemId, Item updateItem);
	// save�� insert �� row�� ���� return, update�� ������ row�� ���� return
}
