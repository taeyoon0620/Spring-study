package himedia.spring.ver3.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import himedia.spring.ver3.controller.domain.Member;
//상속을받을클래스를만들어야한다 memberrepository를 그래서 만든게 MemoryMemberRepository

@Repository
public class MemoryMemberRepository implements MemberRepository{
	
	// 타입 MAP = 순서보장 키값형태.
	private static Map<Long, Member> store = new HashMap<Long, Member>();
	private static Long sequence = 0L; // L 접미사 0 INTEGER
	
	public MemoryMemberRepository() {
		System.out.println("[MemoryMemberRepository] 생성자 실행됨");
	}
	
// if componenet라는 어노테이션이있다면, ex) repository, controller 
// string boot가 시작이되는 단계에 해당이되는 bean 생성해서 spring container안에 들어가게된다 
	
	@Override
	public Member save(Member member) {
		//System.out.println("[repository] save() 실행");
		//System.out.printf("id : %s, name : %s\n", member.getId(), member.getName());
		
		member.setId(++sequence);
		// id의 값 선 증가 
		store.put(member.getId(), member);
		// 저장한 아이디를 꺼내오는게 더 좋음 . member.getId();
		
		//System.out.printf("id : %s, name : %s\n", member.getId(), member.getName());
		//System.out.println("[repository] save() 종료");
		return member;
	} 
    
    @Override
    public Optional<Member> findbyId(Long id) {
    	return Optional.empty();
    }
    

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

	@Override
	public List<Member> findAll() {
		return new ArrayList<Member>(store.values());
	}

}
//tr은하나 members 에따라 tr이 늘어나야함 members 객체에 늘어남에따라 tr도 늘어나야한다 .
//model에 저장된 members에따라 tr도늘어나야함   반복문을 써야한다. thymeleaf 반복문