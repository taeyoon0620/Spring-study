package himedia.spring.ver3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")  // 기본 경로 설정
public class ItemController {

    @GetMapping("/items")  // 요청이 들어오는 페이지 설정.
    public String index(Model model) {
        System.out.println("@@@ store/items로 이동!");
        return "store/items"; // 논리 뷰 이름 반환
    }

    @GetMapping("/items/1")
    public String item() {
    	return "store/item";
    }
    
    @GetMapping("/items/add")
    public String add() {
    	return "store/addForm";
    }
    
    @GetMapping("items/1/edit")
    public String editForm() {
    	return "store/editForm";
    }
    
	// HTTP METHOD : GET 
	// URI : /store/items
	// 기능 : 상품 목록 조회
	// 물리 view : /store/items.html
}
