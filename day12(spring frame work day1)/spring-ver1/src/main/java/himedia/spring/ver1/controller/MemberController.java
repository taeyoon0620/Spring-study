package himedia.spring.ver1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	//method : Get
	@RequestMapping("/member") 
	public String member() {
		return "member/index";
	}
	
	//requet method : GET
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	// get , post 요청 @RequestMapping은 다해준다.
	public String join(@RequestParam("id") Integer id, 
			@RequestParam("name") String name, 
			Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "member/join";
	}
	
	
	
	
	
	
	
	
	
	
	}
	

