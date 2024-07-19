package himedia.spring.ver3.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import himedia.spring.ver3.controller.domain.Member;

// row 하나가 객체하나이다. table에 row하나가 객체하나
// 순수 jdbc

//@Primary
@Repository
public class JDBCMemberRepository implements MemberRepository {

	private final DataSource dataSource;
	
	//@Autowired
	public JDBCMemberRepository(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("[JDBCMemberRepository] 생성자 실행");
	}
	
	@Override
	public Member save(Member member) {
		String sql = "insert into member(name) values(?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, member.getName());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			// rs = result set.
			if(rs.next()) {
				member.setId(rs.getLong(1));	
				//로우 하나 (컬럼의 번호) 리턴이되는게 하나 반복문없이 if문을썼다. 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
					// 자원해제
				if(conn != null)
					conn.close();
				    // 자원해제
			} catch(Exception e2) {
				e2.printStackTrace();
			}			
		}
		return member;
	}	
	@Override
	public Optional<Member> findById(Long id) {
		String sql = "select * from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// table에있는데이터를 result set으로 반환해줬다.
		// column 정보도 같이온다.
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 쿼리문 준비
			pstmt.setLong(1, id);
			// 1= 첫번째 파라미터 ,에 id를 설정.
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Member member = new Member();
				// 빈객체 생성 .
				member.setId(rs.getLong("id"));
				//  리턴이 된 정보 저장 id = column명  getLong -> Long 의타입으로 꺼내오라는뜻 
				member.setName(rs.getString("name"));
				// rs를통해서 해당이되는 name column을 찾아가서 이름을 string으로 뽑아오세요 라는뜻 
				return Optional.of(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) 		rs.close();
				if(pstmt != null) 	pstmt.close();
				if(conn != null) 	conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return Optional.empty();
	}
	@Override
	public Optional<Member> findByName(String name) {
		String sql = "select * from member where name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setName(rs.getString("name"));
				return Optional.of(member);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}			
		}
		return Optional.empty();
	}
	@Override
	public List<Member> findAll() {
		// 변수가들어간건없어서 정적query
		
		String sql = "select * from member";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> members = null;
		
		// arrayList에 배열처럼 id, name을 저장 참조변수 members
		// 하나의 객체에 하나의 row를 저장한다.
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			members = new ArrayList<>();
			
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setName(rs.getString("name"));
				members.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}			
		}
		return members;
	}

}