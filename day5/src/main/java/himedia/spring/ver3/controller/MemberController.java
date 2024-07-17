package himedia.spring.ver3.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.spring.ver3.controller.domain.Member;
import himedia.spring.ver3.controller.domain.MemberForm;
import himedia.spring.ver3.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	// 객체생성 
	
	/* ======================================================
	 * MemberController는 MemberService에 의존한다.
	 * [방법 1] 직접 객체를 생성한다.
	 * [방법 2] 생성자를 통한 의존성 주입한다.
	 * ======================================================
	 */
	
	/*
	 * ==================================================================== 
	 * [방법1] 직접 bean(객체, 인스턴스) 생성 // private final MemberService service = new
	 * MemberService();
	 * 
	 * [방법2] DI(의존성 주입) 구현  
	 * 1) 생성자 주입 : constructor injection ** 권장 **
	 * 2) 필드주입 : field injection  
	 * 3) 세터 주입 : setter injection 
	 * 
	 * [IoC] Inversion of Control : 제어의 역전 
	 * : 제어의 흐름을 바꾼다 (스프링 컨테이너가) 우리가아닌  
	 * : 객체의 의존서을 역전  
	 * =====================================================================
	 */
	
	// [방법 2-1] 생성자를 통한 DI ===============================================
//	private final MemberService service;
//
//	// @Autowired
//	// 자동주입 표시해주는 어노테이션 @Autorwired 생성자가많을때 사용함 생략하는게좋음
//	public MemberController(MemberService service) {
//		this.service = service;
//		System.out.println("[MemberController] MemberService");
//	}
	
	// [방법 2-2] 필드(Field)를 통한 DI (final을 지워줘야함)==========================
	@Autowired private MemberService service;
	
	// final이 없으므로 변경이 가능하다.
	
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
		
		//System.out.println("[Post Mapping] controller >> create method 실행됨");
		//System.out.println("form >> " + form);
		System.out.println("[Controller] form.getName >> " + form.getName());

		// 빈 객체 생성 
		Member member = new Member();
		member.setName(form.getName());
		
		// repository code...
		
		// repository.save(member);
		
		// service code...
		Long id = service.join(member);
		System.out.println("[controller] 가입된 회원의 아이디 >> " + id);
		
		// System.out.println("[Post Mapping] create method 종료됨");
		// return "home";
		
		return  "redirect:/";
		
		// redirect (다시 요청) => "redirect: 원하는경로로 설정"
		// Get 요청방식 
		// Post를 사용한다면 return을 redirect로 처리하는게좋다. 
	}

	
	@GetMapping("/list")
	public String memberList(Model model) {
		
		// repository code.......
		// List<Member> members = repository.findAll();
		//model.addAttribute("members", members);
		
		// service code.......
		List<Member> members = service.findAllMember();
		model.addAttribute("members", members);
		
		return "/members/member-list";
	}
	
	@GetMapping("/search")
	public String memberSearch() {
		return "members/search";
	}
	
}
//// PRG 패턴
////물론, PRG에 대해 알려드리겠습니다! **PRG (Post-Redirect-Get)**는 웹 개발에서 권장되는 디자인 패턴 중 하나입니다.
//이 패턴은 HTTP POST 요청에 대한 응답이 또 다른 URL로의 GET 요청을 위한 리다이렉트를 해야 한다는 것을 의미합니다.
//간단히 말하면, 사용자가 웹 폼을 작성하고 제출한 후, 서버는 폼 데이터를 처리한 후 클라이언트를 다른 URL로 리다이렉트시키는 것입니다.
////
////PRG 패턴을 사용하는 이유는 새로고침으로 인한 중복 요청을 방지하기 위해서입니다. 
//예를 들어, 사용자가 상품 등록 정보를 입력하고 저장한 후 새로고침을 누르면 이전에 
//입력한 데이터가 다시 서버로 전송되어 중복 등록되는 문제를 PRG 패턴으로 해결할 수 있습니다.
////
////이 패턴은 웹 애플리케이션에서 사용자 경험을 개선하고 중복 요청을 방지하는 데 유용합니다. 
//PRG 패턴을 적용하면 사용자가 새로고침을 눌러도 동일한 요청이 반복되지 않으며, 
//데이터의 안정성과 일관성을 유지할 수 있습니다
