package himedia.spring.ver2.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import himedia.spring.ver2.dto.Member;
import himedia.spring.ver2.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final MemberRepository repository;
	
	// [DI] : 의존성주입
	// @Autowired 
	public MemberController(MemberRepository repository) {
		super();
		this.repository = repository;
		System.out.println("controller [MemberController] 실행됨!");
	}

	//method : Get
	//@RequestMapping(value= "/member/new", method = RequestMethod.GET) // 요청이들어오는페이지 설정.
	//@RequestMapping(value= "/new", method = RequestMethod.GET) // 요청이들어오는페이지 설정.
	@GetMapping("/new")
	public String memberNew() {
		return "member/newForm"; //논리뷰
	}
		 
	 //PRG 패턴
	 @PostMapping("/new")
	 //public String postNew(@RequestParam("name") String name ) {
	 public String postNew(@ModelAttribute("member") Member member ) {
		 //System.out.println("[Post] /member/new 요청 : " + name);
		 System.out.println("[Post] /member/new 실행 ");
		 
		 System.out.println("[save() 호출 전] member.getName(): " + member.getName());
		 System.out.println("[save() 호출 전] member.getId(): " + member.getId());
		 Long result = repository.save(member);
		 System.out.println("save() 리턴값 >> " + result);
		 System.out.println("[save() 호출 후]member.getName()저장전 : " + member.getName());
		 System.out.println("[save() 호출 후]member.getId()저장전 : " + member.getId());
		 
		 //return "index";
		 return "redirect:/";
	 }
	 
	 // 요청   URI   : /member/new
	 // 요청 method  : post
	 // handler name : postNew
	 // response page: index
	
	/* @RequestMapping(value="/list", method=RequestMethod.GET) */
	 
//	 @GetMapping("/list")
//	 public String memberList(Model model) {
//		 
//		 List<Member> members = repository.findAll();
//		 model.addAttribute("members", members);
//		 
//		 return "member/memberList";
//	 }
	 
	 
	 
	 @GetMapping("/list")
	// public String memberList() {
		 public ModelAndView memberList() {
		 System.out.println("memberList() 실행! : ModelAndView");
		 
		 List<Member> members = repository.findAll();
		 ModelAndView mv = new ModelAndView(); 
		 // 객체 생성 (모델도 관리 뷰도관리)
		 
		 mv.addObject("members", members);
		 // 담을때
		 
		 mv.setViewName("member/memberList");
		 // view로 이동 (이동할곳)
		 return mv;
		 // model.addAttribute("members", members);
		 // return "member/memberList";
	 }
	 
	 @GetMapping("/search")
	 public String memberSearch(@ModelAttribute("member") Member member, Model model ) {
		 
		 System.out.println("memberSearch() 실행");
		 System.out.printf("아이디 : %s , 이름 : %s\n" , member.getId(), member.getName());
		 
		 Optional<Member> searchmember = Optional.empty();
		 
		 if(member.getId() != null ) {
			 searchmember = repository.findById(member.getId());
		 } else if(!member.getName().isEmpty()) {
			 searchmember = repository.findByName(member.getName());
		 }
		 
		 if(searchmember.isPresent()) {
			 model.addAttribute("member", searchmember.get());
		 }else {
			 model.addAttribute("member", new Member());
		 }
		 
		 return "member/search";
	 }
	 
   	// [학습용] =========================================================================
	
	 //get만처리하게설정해준것
	 @RequestMapping(value= "/join", method = RequestMethod.GET)
	 public String join(@RequestParam("name") String name) {
		 System.out.println("이름 : "  + name);
		 return "index";
	 }
	 
	 //post만처리하게설정해준것
	 @RequestMapping(value = "/join",  method = RequestMethod.POST)
	 public String postJoin(@RequestParam("name") String name) {
		 System.out.println("[POST] /member/join 요청 : " + name);
		 return "index";
	 }
	 
	// =========================================================================
	 
}
