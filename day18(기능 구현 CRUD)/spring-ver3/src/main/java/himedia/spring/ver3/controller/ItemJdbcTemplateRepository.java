package himedia.spring.ver3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import himedia.spring.ver3.dto.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class ItemJdbcTemplateRepository implements ItemRepository {

	private static final Logger log = LoggerFactory.getLogger(ItemJdbcTemplateRepository.class);

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ItemJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		System.out.println("[repository] ItemJdbcTemplateRepository 실행!");
	}
	
	@Override
	public void save(Item item) {
		log.info(">>> save() 시작");

		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
			.withTableName("item")
			.usingGeneratedKeyColumns("id");
		
		long id = jdbcInsert
				.executeAndReturnKey(new BeanPropertySqlParameterSource(item))
				.longValue();
		
		item.setId(id);
		log.info(">>> id 값 : " + id);
		log.info(">>> save() 종료");
	}

	@Override
	public Optional<Item> findById(Long id) {
		String sql= "select * from item where id = ?";
		return jdbcTemplate
				.query(sql, new BeanPropertyRowMapper<>(Item.class), id)
				.stream()
				.findAny();
	}

	@Override
	public Optional<Item> findByName(String name) {
		String sql = "select * from item where name = ?";
		return jdbcTemplate
				.query(sql, new BeanPropertyRowMapper<>(Item.class), name)
				.stream()
				.findAny();
	}

	@Override
	public List<Item> findAll() {
		String sql = "select * from item";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Item.class));
	}

	@Override
	public Item update(Long itemId, Item updateItem) {
		String sql = "update item set name = ?, price = ?, quantity = ? where id = ?";
		
		jdbcTemplate.update(sql, 
			updateItem.getName(), 
			updateItem.getPrice(), 
			updateItem.getQuantity(), 
			itemId);
		
		return updateItem;
	}
	@Override
	List<Item> findByNameContaining(String name);
}
