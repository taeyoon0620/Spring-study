package himedia.spring.ver2.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import himedia.spring.ver2.dto.Member;

//@Primary
//@Repository
public class MemberJdbcTemplateRepository implements MemberRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	public MemberJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//		System.out.println("[repository] MemberJdbcTemplateRepository 실행됨 ");
//	}
	
	public MemberJdbcTemplateRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("[repository] MemberJdbcTemplateRepository 실행됨 ");
	}

	@Override
	public Long save(Member member) {
		System.out.println(">>> save() 실행 시작 >>>");
		
		// insert into member(name) values(?);
		
		// insert문
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate)
			.withTableName("member") // insert into table (query문)
			.usingGeneratedKeyColumns("id"); // auto_increment
		
//		// 매개변수로 받은 member 에서 이름을 getName(추출하여) HashMap에 저장
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("name", member.getName());
//		// 실행하기 
//		Long key = insertActor.executeAndReturnKey(parameters).longValue();
		
		// 위에 주석처리한 코드 한줄로 바꾸기
		Long key = insertActor
				.executeAndReturnKey(new BeanPropertySqlParameterSource(member))
				.longValue();
		member.setId(key);
		
		System.out.println(">>> save() 실행 종료 >>>");
		return member.getId();
	}

	@Override
	// 아이디로 검색 
	public Optional<Member> findById(Long id) {
		List<Member> result
		= jdbcTemplate.query("select * from member where id = ?" ,
				new BeanPropertyRowMapper<Member>(Member.class), id);
		return result
				.stream()
				.findAny();
	}

	@Override
	// 이름으로 검색
	public Optional<Member> findByName(String name) {
		return jdbcTemplate.query("select * from member where name like ?",
				new BeanPropertyRowMapper<Member>(Member.class),
				name)
				.stream()
				.findAny();
	}

	@Override
	// 전체 검색 (전체 회원 목록)
	public List<Member> findAll() {
		return jdbcTemplate.query(
				"select * from member",
				new BeanPropertyRowMapper<Member>(Member.class));
	}
	
}
