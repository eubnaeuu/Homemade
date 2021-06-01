package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;

public interface MemberService {

	//로그인
		void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
		
	// 회원정보조회
		MemberVO getMember(String id) throws SQLException;
		
		List<MemberVO> selectAllMember() throws SQLException;
		
		List<MemberVO> selectMember(MemberVO memberVo) throws SQLException;
		
		int registerMember(MemberVO memberVo) throws SQLException;

		int deleteMember(String memId) throws SQLException;

		int updateMember(MemberVO memberVo) throws SQLException;
		
		List<MemberVO> getMemberList() throws SQLException;
		List<MemberVO> getMemberList(Criteria cri) throws SQLException;
		Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException;
		
		
		
		
		
}
