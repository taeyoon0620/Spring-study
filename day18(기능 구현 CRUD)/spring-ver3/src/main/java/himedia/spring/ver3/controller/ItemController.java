package himedia.spring.ver3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.spring.ver3.dto.Item;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/store")  // 기본 경로 설정
public class ItemController {
    
    private final ItemJdbcTemplateRepository repository;
    
    @Autowired
    public ItemController(ItemJdbcTemplateRepository repository) {
        this.repository = repository;
        log.info("[controller] ItemController 실행!");
    }

    @GetMapping("/items")  // 요청이 들어오는 페이지 설정
    public String index(Model model) {
        List<Item> items = repository.findAll();
        model.addAttribute("items", items);
        log.info("@@@ store/items로 이동!");
        return "store/items"; // 논리뷰 이름 반환
    }

    // [상품 상세] ==================================================================
    @GetMapping("/items/{itemId}")
    public String item(@PathVariable(name = "itemId") Long itemId, Model model) {
    	
    	Item item = repository.findById(itemId).get();
    	model.addAttribute("item", item);
        //log.info("item id : {}", itemId);
        return "store/item";
    }
    
    // 상품 수정
    @GetMapping("/items/{itemId}/edit")
    public String editForm(@PathVariable(name = "itemId") Long itemId,
    		Model model) {
    	Item item = repository.findById(itemId).get();
    	model.addAttribute("item", item);
        return "store/editForm";
    }

    // [상품 등록 폼] =============================================================
    @GetMapping("/items/add")
    public String add() {
        return "store/addForm";
    }
    
    // [상품 등록] 저장 ============================================================
    @PostMapping("/items/add")
    public String postAddForm(@ModelAttribute(name = "item") Item item) {
        log.info("상품 등록...");
        repository.save(item);
        return "redirect:/store/items/" + item.getId();
    }
    
    // [상품 수정] ===================================================================
    @PostMapping("/items/{itemId}/edit")
    public String edit(@PathVariable(name = "itemId") Long itemId,
    		@ModelAttribute(name = "item") Item item) {
    	
    	log.info("아이디 {}인 상품 수정 실행 !!", itemId);
    	log.info("id: {}, name : {}", item.getId(), item.getName());
    	
    	repository.update(itemId, item);
    	
    	return "redirect:/store/items/{itemId}";

    @GetMapping("/store/items/search")
    public String searchItems(@RequestParam("search") String search, Model model) {
        List<Item> items = itemService.findByName(search);
        model.addAttribute("items", items);
        return "itemList";
    }
    }
}
