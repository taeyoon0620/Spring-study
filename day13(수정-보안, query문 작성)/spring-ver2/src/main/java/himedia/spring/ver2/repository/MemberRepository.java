package himedia.spring.ver2.repository;

import java.util.List;
import java.util.Optional;

import himedia.spring.ver2.dto.Member;

public interface MemberRepository {
	
	Long save(Member member);
	Optional<Member> findById(Long id);  
	Optional<Member> findByName(String name);  
	List<Member> findAll();
	
}
