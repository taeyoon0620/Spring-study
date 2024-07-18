package himedia.spring.ver3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.spring.ver3.controller.domain.Member;
import himedia.spring.ver3.repository.MemberRepository;

@Service
public class MemberService {
	
	/*
	 * ======================================================
	 * MemberService는 MemberRepository에 의존한다.
	 * [방법 1] 직접 객체를 생성한다.
	 * [방법 2] 생성자를 통한 의존성 주입한다.
	 * ======================================================
	 */
	
	// [방법 1]
	// private final MemberRepository repository = new MemoryMemberRepository();

	// [방법 2] 생성자가 하나일때는 @autowired 생략가능. 두개일때는 어노테이션 생략불가능 .
	private final MemberRepository repository;
	
	@Autowired
	public MemberService(MemberRepository repository) {
		this.repository = repository;
		System.out.println("[MemberService] 생성자 실행됨 : 매개변수 1개 ");
	}
	
	public MemberService(MemberRepository repository, int age) {
		this.repository = repository;
		System.out.println("[MemberService] 생성자 실행됨 : 매개변수 2개 ");
	}
		
//Failed to instantiate [himedia.spring.ver3.service.MemberService]: No default constructor found
// 생성자가 여러개있어서 자동주입을 할 생성자를찾지못함 . 
// 그래서 어노테이션 Autowired를 붙여줘야 알수있다 어떤생성자를 사용할지 알려줘야함.
	
	/**
	 * controller -> Service -> repository
	 * [저장] 회원 가입
	 * 
	 */
	public Long join(Member member) {
		repository.save(member);
		return member.getId();
	}
	
	/*
	 * [조회] 아이디로 검색
	 */
	
	public Optional<Member> findId(Long memberId) {
		return repository.findbyId(memberId);
	}
	/*
	 * [조회] 이름으로 검색
	 */
	
	public Optional<Member>findName(String memberName) {
		return repository.findByName(memberName);
	}
	
	
	/*
	 * [조회] 전체 회원 검색하기 
	 * findAllMember 메소드명 
	 */
	 public List<Member> findAllMember() {
		 return repository.findAll();
	 }
	
	
}
// 실행되면 bean이 생성이됐다.
// 순서 1. repository -> 2. service -> 3. controller 
// memberRepoistory - > memberservice -> membercontroller