package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;
import kr.or.ddit.util.MyUtils;

public class MemberServiceImpl implements MemberService {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			if (member == null)
				throw new NotFoundIDException();
			if (!pwd.equals(member.getPwd()))
				throw new InvalidPasswordException();
		} finally {
			session.close();
		}
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			return member;
		} finally {
			session.close();
		}
	}

	@Override
	public List<MemberVO> selectAllMember() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		List<MemberVO> list = null;
		try {
			list = memberDAO.selectAllMember(session);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<MemberVO> selectMember(MemberVO memberVo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		List<MemberVO> list = null;
		try {
			list = memberDAO.selectMember(session, memberVo);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int deleteMember(String memId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		int cnt = -1;
		try {
			cnt = memberDAO.deleteMember(session, memId);
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memberVo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		int cnt = -1;
		try {
			cnt = memberDAO.updateMember(session, memberVo);
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int registerMember(MemberVO memberVo) throws SQLException {
SqlSession session = sqlSessionFactory.openSession(false);
		
		// 빈칸
		// 중복검사
		// 정규화
		
		int cnt = -1;
		
		MyUtils myUtils = new MyUtils();
			
		cnt = memberDAO.insertMember(session, memberVo);
		session.close();
		
		return cnt;
	}

}
