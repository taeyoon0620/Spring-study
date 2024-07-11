package himedia.spring.ver1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	// [handler] 핸들러 ==============================(메소드)
	@GetMapping("/books/book")
	public String book() {
		return "book";
	}
	
	
}
