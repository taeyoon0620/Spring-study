package himedia.spring.ver1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	
	// [handler] 핸들러 ==============================(메소드)

	@GetMapping("/item")
	public String name() {
		return "item";
	}

	@GetMapping("/item-list")
	public String itemList() {
		return "items";
	}
	
//	@GetMapping 논리 view ,  물리 view = 파일 book.html   
//	public String welcome() {
//		return "welcome";
//		//  슬래쉬/이렇게 파일경로를 설정안해도 view resolver 가 알아서 붙여줌.
//	}
	
	@GetMapping({"/", "/welcome"}) // 중괄호로 묶어주면 최상위(/) 또는 welcome view 를 선택하게 설정할수있다.
	public String welcome2() {
		return "welcome";
	}
	
	@GetMapping("/item-view") 
	public String itemView(Model model) {
		model.addAttribute("title", "새우깡");
		model.addAttribute("price", "1500원 ");
		return "item-view";
	}
	
//	@GetMapping("/welcome")
//	public String welcome2() {
//		return "welcome";
//	}
//	
	
//	@GetMapping("/item") 
//	public String haha() {
//		return "welcome"; 
//	} Error -> 중복 There is already 'itemController' bean method

}
