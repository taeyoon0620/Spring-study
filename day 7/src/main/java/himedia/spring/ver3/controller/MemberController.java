package himedia.spring.ver3.controller;
import java.util.List;
import java.util.Optional;

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
	private final MemberService service;

	// 자동주입 표시해주는 어노테이션 @Autorwired 생성자가많을때 사용함 생략하는게좋음
	public MemberController(MemberService service) {
		this.service = service;
		System.out.println("[MemberController] MemberService");
	}
	
	// [방법 2-2] 필드(Field)를 통한 DI (final을 지워줘야함)==========================
//	@Autowired private MemberService service;
	
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
	
	// [방법1] RequestParam
	// 요청 URL: http://localhost:8080/members/search?id=1&name=         key id , name value
//	@GetMapping("/search")
//	public String memberSearch
//		(@RequestParam(name = "id", 
//				required = false
//				//defaultValue = "0"
//				) Long id,
//			@RequestParam(name = "id", 
//			required = false
//			)
//	 String name, Model model) {
//		System.out.println("[controller] id >> " + id);
//		System.out.println("[controller] name >> " + name);
//		System.out.println("[controller] name 빈 문자열이니? >> " + name.isEmpty());
//		
//		// 할려는것 : 아이디로 검색했을때 아무것도안넣고 검색을했을때 페이지가 오류 뜨는걸 고치고싶다.  
//		
//		// Member member = null;
//		//[Error] Exception processing template "members/search": Exception evaluating SpringEL expression: "member.id
//		//[Error] EL1007E: Property or field 'id' cannot be found on null
//		// 해결법 : 
//		// 1. null을 view로안보낸다 2. view로 null을보낸다 (view에서 null 처리 코드작성 thymeleaf)
//		
//		// 1. 해결법 :  빈객체를 보낸다(생성).
//		Member member = new Member(); // 빈 객체 
//		// 잘됩니다. 오류페이지도안뜨고 페이지도 잘이동됩니다. id, name을 null 로 처리해준다
//		
//		// id로검색 이름으로검색 
//		if(id != null) {
//			member = service.findId(id).get();		
//		} else if(!name.isEmpty() ) {
//			member = service.findName(name).get();
//		}
//		
//		System.out.println("[controller] 검색후 member " + member);
//		model.addAttribute("member", member);
//		
//		return "members/search";
//	}
	
	// [문제] ============================================================================
	// : 없는 회원의 아이디나 이름 검색시 발생되는 Error 처리 
	// : [Error] java.util.NosuchElementExcetpion: No value prsent
	// ==================================================================================
	
//	@GetMapping("/search")
//	public String memberSearch
//		(@RequestParam(name = "id", required = false) Long id,
//			@RequestParam String name, Model model) {
//		System.out.println("[controller] id >> " + id);
//		System.out.println("[controller] name >> " + name);
//		System.out.println("[controller] name 빈 문자열이니? >> " + name.isEmpty());
//		
//		// 할려는것 : 아이디로 검색했을때 아무것도안넣고 검색을했을때 페이지가 오류 뜨는걸 고치고싶다.  
//		
//		// Member member = null;
//		//[Error] Exception processing template "members/search": Exception evaluating SpringEL expression: "member.id
//		//[Error] EL1007E: Property or field 'id' cannot be found on null
//		// 해결법 : 
//		// 1. null을 view로안보낸다 2. view로 null을보낸다 (view에서 null 처리 코드작성 thymeleaf)
//		
//		// 타입을 optional로 설정
//		Optional<Member> member = Optional.empty(); // 빈 객체 
//		
//		// id로검색, 이름으로검색 
//		if(id != null) {
//			member = service.findId(id);		
//		} else if(!name.isEmpty() ) {
//			member = service.findName(name);
//		}
//		
//		if(member.isPresent()) 		
//			model.addAttribute("member", member.get());
////		else 
////			// Null 일떄 빈 객체 넘기기 (조건)
////			model.addAttribute("member", new Member());
//		
//		return "members/search";
//	}
	
	// 위 코드 정리
	
//	@GetMapping("/search")
//	public String memberSearch
//		(@RequestParam(name = "id", required = false) Long id, String name, Model model) {
//		
//		// 할려는것 : 아이디로 검색했을때 아무것도안넣고 검색을했을때 페이지가 오류 뜨는걸 고치고싶다.  
//		
//		// Member member = null;
//		//[Error] Exception processing template "members/search": Exception evaluating SpringEL expression: "member.id
//		//[Error] EL1007E: Property or field 'id' cannot be found on null
//		// 해결법 : 
//		// 1. null을 view로안보낸다 2. view로 null을보낸다 (view에서 null 처리 코드작성 thymeleaf)
//		
//		// 타입을 optional로 설정
//		Optional<Member> member = Optional.empty(); // 빈 객체 
//		
//		// id로검색, 이름으로검색 
//		if(id != null) {
//			member = service.findId(id);		
//		} else if(!name.isEmpty() ) {
//			member = service.findName(name);
//		}
//		
//		if(member.isPresent()) 		
//			model.addAttribute("member", member.get());
////		else 
////			// Null 일떄 빈 객체 넘기기 (조건)
////			model.addAttribute("member", new Member());
//		
//		return "members/search";
//	}
	
	// [방법2] @ModelAttribute 
	
	// [Reflection 기법]========================================================
	// : view -> controller
	// : 자동으로 setter 실행 -> 데이터 자동 처리
	// 
	// : [Parameter 에 사용되는 @ModelAttribute 와 Model 차이] =======================
	// @ModelAttrivute : view -> controller로 데이터 넘어올 떄 
	// Model           : controller -> view로 데이터 넘길 떄 
	//
	//
	// =========================================================================
	
	
	// 생성자 또는 setter 실행 
	
//		@GetMapping("/search")
//		public String memberSearch(@ModelAttribute(binding = true) Member member, Model model) {
//			System.out.println("\n[방법2] @ModelAttribute");
//			System.out.println("<< view -> controller로 넘어온 데이터 >> " );
//			System.out.println("member >> " + member);
//			System.out.println("member id >> " + member.getId());
//			System.out.println("member name >> " + member.getName());
//			//System.out.println("member name 빈 문자열이니? >> " + member.getName().isEmpty());
//			
//			// 직접 Binding =========================================================================
//			member.setId(200L);
//			member.setName("호호");
//			// =====================================================================================
//			
//			//model.addAttribute("member", member);
//			// 이걸안써도 @ModelAttribute는 알아서 작동한다.
//			
//			System.out.println("<< model로 바인딩된 데이터 >> " );
//			System.out.println("model.getAttribute(/member/) >> " + model.getAttribute("member"));
//			System.out.println("model.getAttribute(/member/).getClass() >> " + model.getAttribute("member").getClass());
//			System.out.println("model.getAttribute(member) : name  >> " + ((Member)model.getAttribute("member")).getId());
//			System.out.println("model.getAttribute(member) : id >> " + ((Member)model.getAttribute("member")).getName());
//			
//			// ModelAttribute 특성 (reflection 기법으로 저장해줌)
//			// model 알아서 binding
//			// view에서 넘어온것받아주고 ,add attribute로 넘겨준다 
//			return "members/search";
//		}
//	@GetMapping("/search")
//	public String memberSearch(@ModelAttribute Member member, Model model) {
//		System.out.println("\n[방법2] @ModelAttribute");
//		System.out.println("<< view -> controller로 넘어온 데이터 >> " );
//		System.out.println("member >> " + member);
//		System.out.println("member id >> " + member.getId());
//		System.out.println("member name >> " + member.getName());
//		
//		// [조회하기]
////		Member searchMember = new Member();
//		
//		Member searchMember = new Member();
////		Optional<Member> searchMember1 = Optional.empty(); // 빈 객체 
//
//		
//		// 없는 아이디 검색하거나 없는 이름 검색하면 error page 안뜨게 처리해주기. 
//		if(member.getId() != null)  
//			searchMember = service.findId(member.getId()).get();
//		else if(!member.getName().isBlank())
//			searchMember = service.findName(member.getName()).get();
//		
//		System.out.println("searchMember  >> " + searchMember );
//		
//		System.out.println("<< model로 바인딩된 데이터 >> " );
//		System.out.println("[변경 전]");
//		System.out.println("model.getAttribute(/member/) >> " + model.getAttribute("member"));
//		System.out.println("model.getAttribute(/member/).getClass() >> " + model.getAttribute("member").getClass());
//		System.out.println("model.getAttribute(member) : id >> " + ((Member)model.getAttribute("member")).getName());
//		System.out.println("model.getAttribute(member) : name  >> " + ((Member)model.getAttribute("member")).getId());
//		
//		model.addAttribute("member", searchMember);
//		
//		System.out.println("[변경 후]");
//		System.out.println("model.getAttribute(/member/) >> " + model.getAttribute("member"));
//		System.out.println("model.getAttribute(/member/).getClass() >> " + model.getAttribute("member").getClass());
//		System.out.println("model.getAttribute(member) : id >> " + ((Member)model.getAttribute("member")).getName());
//		System.out.println("model.getAttribute(member) : name  >> " + ((Member)model.getAttribute("member")).getId());
//		
//		
//		// ModelAttribute 특성 (reflection 기법으로 저장해줌)
//		// model 알아서 binding
//		// view에서 넘어온것받아주고 ,add attribute로 넘겨준다 
//		return "members/search";
//		
//	}
	
	// 위코드 정리
	@GetMapping("/search")
	public String memberSearch(@ModelAttribute Member member, Model model) {
		
		// 없는 아이디 검색하거나 없는 이름 검색하면 error page 안뜨게 처리해주기. 
		Optional<Member> result = Optional.empty();
		
		if(member.getId() != null)  
			result = service.findId(member.getId());
		else if(!member.getName().isBlank())
			result = service.findName(member.getName());
		
		if(result.isPresent())
			model.addAttribute("member", result.get());
		else 
			//빈 객체 넘기기
			model.addAttribute("member", new Member());
		
		return "members/search";
	}		
}

	// [ERROR] Required request parameter 'id' for method parameter type Long is present but converted to null]
	//  해결법 : parameter에  required = false 설정하기 (parameter에 아무런값이없어도 된다라는 뜻) 

	// [ERROR] No value present 해결법
	// 	//자바에서 위 에서는 Optional.get(); 을 사용할 때 값이 없을 경우에 위와 같이 No value present 에러가 발생하게 되는데
	//isPresent() 등을 사용해값이 없을 때 .get()을 사용하지 않도록 코드를 변경해주면 해결된다 


	
	// [방법2] Modelattribute
	
//	@GetMapping("/search")
//	public String memberSearch(@RequestParam("id")) {
//		return "members/search";
//	}

//[view] home.html ---> [get] 요청 /members/new -> 응답 new.html
//[view] new.html ----> [post] 요청 /members/new 

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
