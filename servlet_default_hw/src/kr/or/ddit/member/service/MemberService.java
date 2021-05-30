package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.servlet.exception.InvalidPasswordException;
import kr.or.ddit.servlet.exception.NotFoundIDException;
import kr.or.ddit.servlet.exception.isEmptyIdException;
import kr.or.ddit.servlet.exception.isEmptyPwdException;

public interface MemberService {

	MemberVO login(String id, String pwd) throws NotFoundIDException, InvalidPasswordException, SQLException;

	MemberVO viewMember(String id) throws SQLException;
	
	List<MemberVO> selectAllMember() throws SQLException;
	
	List<MemberVO> selectMember(MemberVO memberVo) throws SQLException;
	
	int registerMember(MemberVO memberVo) throws SQLException, isEmptyPwdException, isEmptyIdException;

	int deleteMember(String memId) throws SQLException;

	int updateMember(MemberVO memberVo) throws SQLException;

}
