package himedia.spring.ver3.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import himedia.spring.ver3.controller.domain.Member;

@Primary
@Repository
// implements를 해야 DI를 할수있음 상속 
public class JdbcTemplateMemberRepository implements MemberRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcTemplateMemberRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("[JdbcTemplateMemberRepository] 생성자 실행");
	}
	
	private RowMapper<Member> memberRowMapper() {
		return new RowMapper<Member>() {
			
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setName(rs.getString("name"));
				
				return member;
			}
		};	
	}
	// 순주 jdbc에서 이부분이다 위에코드가 
//	Member member = new Member();
//	member.setId(rs.getLong("id"));
//	member.setName(rs.getString("name"));
//	members.add(member);
	
	@Override
	public Member save(Member member) {
		System.out.println("[JdbTemplateMemberRepository] save() 시작");
		
		//데이터 저장 : insert 
		// 객체생성 주소를 저장  jdbcInsert(변수) 에 
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		
		// [insert statement] insert into member(name) values(?)
		// (withTableName("insert 할 테이블명")
		// usingGeneratedKeyColumns("자동증가 컬럼명")
		
		jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id"); // insert문 만들기
		
		// 컬럼값 지정 
		// DB의 member table에 저장할 데이터를 HashMap에 추가 
		//어떤 컬럼, 어떤값 을 넣을지 알려주기 <> string 일수도있지만 int일수도있다 . 그래서 object
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", member.getName());
		
		// paramters.put("컬럼명", "값")
		
		// 마지막을 기준으로 insert 마지막값 id
		// SQL 실행 후 생성된(저장된) key (PK : member table id) 리턴받기.
		// Number key = jdbcInsert.executeAndReturnkey(parameters);
		// 자동 생성이된 key 리턴됨
		Number key = jdbcInsert.executeAndReturnKey(parameters);
		System.out.println("DB 저장 후 리턴 받은 key value >> " + key);

		// 리턴받을 KEY를 MEMBER에 저장
		member.setId(key.longValue()); //꺼내올 type 지정
		
		System.out.println("[JdbTemplateMemberRepository] save() 종료");
		return member;
		
	}
	
//	String sql = "insert into member(name) values(?)";
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
	
	//동적쿼리
	@Override
	public Optional<Member> findById(Long id) {
		List<Member> result = jdbcTemplate.query("select * from member where id = ?",
				memberRowMapper(), id);
		System.out.println("result의 길이 (size 요소 개수) >>  " + result.size());
		
		for(Member m: result) 
			System.out.printf("id : %s, name : %s\n", m.getId(), m.getName());
		
		return result.stream().findAny();
		
	}
	// 동적 쿼리문 
	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = jdbcTemplate.query("select * from member where name like ? limit 1", memberRowMapper(), name);
				
		System.out.println("result에 저장된 요소 개수(size) : " + result.size());		
				
		for(Member m: result) 
			System.out.printf("아이디 : %s, 이름 : %s\n", m.getId(), m.getName());
		
		return result.stream().findAny();
		// 1개만 리턴 .  result set에 실제로 저장이 2개됨 하지만 하나만찾아서 리턴을한것뿐이다.
	}

	// 정적쿼리
	@Override
	public List<Member> findAll() {
		return jdbcTemplate.query("select * from member" , memberRowMapper());
		//쿼리가 실행 -> result set 을 가지고 결과를 memberRowMapper에 저장
	}
	
}
