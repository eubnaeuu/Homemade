package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;

public interface MemberDao {
	/**
	 * 입력받은 ID값 DB와 비교
	 * @param memId 회원ID
	 * @return 입력한 Id와 일치하는 행
	 * @throws Exception 
	 */
	MemberVO selectMemberByID(SqlSession session, String memId) throws SQLException;

	List<MemberVO> selectAllMember(SqlSession session) throws SQLException;
	
	List<MemberVO> selectMember(SqlSession session, MemberVO memberVo) throws SQLException;
	
	int insertMember(SqlSession session, MemberVO membervo) throws SQLException;

	int deleteMember(SqlSession session, String memId) throws SQLException;

	int updateMember(SqlSession session, MemberVO memberVo) throws SQLException;
	
}
