package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
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
		
		MyUtils myUtils; // = new MyUtils();
			
		cnt = memberDAO.insertMember(session, memberVo);
		session.close();
		
		return cnt;
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
		List<MemberVO> memberList = memberDAO.selectMemberList(session);
		return memberList;
		}finally {
			session.close();
		}
	}
	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			List<MemberVO> memberList = memberDAO.selectMemberList(session,cri);
			return memberList;
		}finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException {
		System.out.println("serviceimpl 입장");
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.selectMemberListCount(session, cri));
			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<MemberVO> memberList = memberDAO.selectMemberList(session,cri);
			
			dataMap.put("memberList", memberList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		}finally {
			session.close();
		}
	}

}
