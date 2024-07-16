package himedia.spring.ver3.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.spring.ver3.controller.domain.Member;
import himedia.spring.ver3.controller.domain.MemberForm;
import himedia.spring.ver3.repository.MemberRepository;
import himedia.spring.ver3.repository.MemoryMemberRepository;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	private final MemberRepository repository = new MemoryMemberRepository();
	// 객체생성 
//	@GetMapping("/members/new")
	
	@GetMapping("/new")
	public String form() {
		return "/members/new";
	}

	//	@GetMapping("/members/join") 
	//		public String join() {
	//			return "home";
	//	}

	
	// [숙제] Request param, @modelAttribute , @Requestbody 차이점 알아오기
	
	
	// Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content-Type 'application/x-www-form-urlencoded;charset=UTF-8' is not supported]
	// 해결법: @Requesbody 어노테이션 제거
	// property method 와 member method 중간적인성격
	@PostMapping("/new")
	public String create(@ModelAttribute MemberForm form) {
		
		
		System.out.println("[Post Mapping] controller >> create method 실행됨");
		System.out.println("form >> " + form);
		System.out.println("form.getName >> " + form.getName());

		Member member = new Member(); // 빈객체 만들고 저장 
		member.setName(form.getName());
		
		
		// repository code...
		repository.save(member);
		
		
		// service code...
		
		System.out.println("[Post Mapping] create method 종료됨");

		return "home";
	}

	
	@GetMapping("/list")
	public String memberList(Model model) {
		
		// repository code.......
		List<Member> members = repository.findAll();
		model.addAttribute("members", members);
		
		// service code.......
		
		
		return "/members/member-list";
	}
	
}
