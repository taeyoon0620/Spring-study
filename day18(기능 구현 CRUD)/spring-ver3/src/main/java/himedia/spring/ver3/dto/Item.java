package himedia.spring.ver3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter

public class Item {
	// field
	private Long id;
	private String name;
	private Integer price;
	private Integer quantity;
	
	// constructor
	public Item(String name, Integer price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	
}
