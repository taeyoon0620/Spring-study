package himedia.spring.ver2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import himedia.spring.ver2.dto.Member;

//@Primary
//@Repository
public class MemberJdbcRepository implements MemberRepository {
	//[DI] 의존성 주입
	//[방법 1] 생성자를 통한 의존성 주입 ====================================

	/*
	 * private final DataSource dataSource;
	 * 
	 * @Autowired public MemberJdbcRepository(DataSource dataSource) {
	 * this.dataSource = dataSource;
	 * System.out.println("[repository] MemberJdbcRepository 실행됨!!!"); 
	 * }
	 */
	
	// [방법 2] 필드를 통한 의존성 주입 [필드 주입(Field Injection)]========================================
	@Autowired private DataSource dataSource;
	
	public MemberJdbcRepository() {
		System.out.println("[repository] MemberJdbcRepository 실행됨  " + " --> 필드 주입 (Field Injection)");
	}
	
	// 필드 주입은 외부에서 접근이 불가능하다는 단점 , 또한 필드 주입은 반드시 DI 프레임워크가 존재해야 하므로 반드시 사용을 지양해야 한다.

	
		
	@Override
	public Long save(Member member) {
		String sql = "insert into member(name) values(?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		//동적 query , 메모리에 들어가면 계속들어가있다 사라지지 않음 
		//메모리에 컴파일이 된상태로 남아있다.
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, member.getName());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				member.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}			
		}
		return member.getId();
	}

	@Override
	public Optional<Member> findById(Long id) {
		String sql = "select * from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
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
		String sql = "select * from member";
		// 정적인 query
		// (?) 도 없다 정적인 query라 select문에 
		Connection conn = null;

		Statement stmt = null;
		
		PreparedStatement pstmt = null;
		// 메모리에 상주 시켜주겠다라는 의미에서 PreparedStaement를 쓰는것
		
		
		ResultSet rs = null;
		List<Member> members = null;
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
// SQL 실행단계
// 1. 쿼리문 분석
// 2. 컴파일 compile 
// 3. 실행


