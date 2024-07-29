package himedia.spring.ver2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//method : Get
	@RequestMapping("/") 
	public String index() {
		return "index"; //논리뷰
	}

}
