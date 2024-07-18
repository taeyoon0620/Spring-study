package himedia.spring.ver3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarketController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	

}
