package himedia.spring.ver2.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import himedia.spring.ver2.dto.Member;

@Repository
public class MemberMemoryRepository implements MemberRepository{
	 
	private static Map<Long, Member> store = new HashMap<Long, Member>();
	private static Long sequence = 0L; // 접미사 L 
	
	public MemberMemoryRepository () {
		System.out.println("[repository] MemberMemoryRepository 실행됨!");
	}
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		System.out.println("저장 완료 !!");
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				.filter(n -> n.getName().equals(name))
				.findAny();
	}
	
	@Override
	public List<Member> findAll() {
		return new ArrayList<Member>(store.values());
	}
	
	
	
	
	
}
