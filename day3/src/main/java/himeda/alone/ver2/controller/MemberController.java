package himeda.alone.ver2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@GetMapping("/join-form")
	public String joinForm() {
		return "member/join-form";
	}
		
    @GetMapping("/join")
    public String join(@RequestParam("userName") String userName, @RequestParam("userAge") int userAge, Model model) {
        model.addAttribute("userName", userName);
        model.addAttribute("userAge", userAge);
        return "member/join";
    }

	
}
