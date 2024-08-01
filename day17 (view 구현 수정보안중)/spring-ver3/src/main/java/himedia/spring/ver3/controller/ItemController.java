package himedia.spring.ver3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/items/edit")
    public String editItem(
            @RequestParam("action") String action,
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("quantity") String quantity,
            RedirectAttributes redirectAttributes) {

        if ("cancel".equals(action)) {
            return "redirect:/store/items/" + id;
        } else if ("save".equals(action)) {
            // 저장 로직을 여기에 추가합니다.
            // 예를 들어, 서비스 클래스를 호출하여 데이터를 저장할 수 있습니다.
            // itemService.save(new Item(id, name, price, quantity));
            return "redirect:/store/items/" + id; // 저장 후에도 동일한 페이지로 리다이렉트
        }
        return "redirect:/store/items/" + id; // 기본 리다이렉트 경로
    }
}
