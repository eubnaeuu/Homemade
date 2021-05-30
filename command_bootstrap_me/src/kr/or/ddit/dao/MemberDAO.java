package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {

	// 회원정보조회
	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
	
	List<MemberVO> selectAllMember(SqlSession session) throws SQLException;
	
	List<MemberVO> selectMember(SqlSession session, MemberVO memberVo) throws SQLException;
	
	int insertMember(SqlSession session, MemberVO membervo) throws SQLException;

	int deleteMember(SqlSession session, String memId) throws SQLException;

	int updateMember(SqlSession session, MemberVO memberVo) throws SQLException;
	
}
