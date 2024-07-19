package himedia.spring.ver3.repository;

import java.util.List;
import java.util.Optional;

import himedia.spring.ver3.controller.domain.Member;

public interface MemberRepository {
	
	Member save(Member member);
	// 반환형 메서드명 (타입 매개변수);
	// 반환형 findbyId (Id의 타입 = Long);
	// optional<Member> findbyId (Long id);
	// 반환형은 찾았을때 없으면 NULL이나올수도있음 그래서 NULL처리를 해야하는데 , optional 이라는 타입을써야한다. (null 처리를 하는데 사용하는 타입이다).
	
	// 저장할려고 사용 (save)
	// member 리턴중 (주소)
	// 반환형 void,Long,boolean 등등 가능  

	Optional<Member> findById (Long id);
	Optional<Member> findByName(String name);
	// name을 기준으로찾아야한다
	
	List<Member> findAll();
	// 반환형 findAll(); member객체를 다 return을 해야한다. 그래서 리턴타입은 collection이 되어야함. generic중의 list를 사용한다



}
