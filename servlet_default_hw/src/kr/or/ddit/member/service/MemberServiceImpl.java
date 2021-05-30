package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;
import kr.or.ddit.servlet.exception.InvalidPasswordException;
import kr.or.ddit.servlet.exception.NotFoundIDException;
import kr.or.ddit.servlet.exception.isEmptyIdException;
import kr.or.ddit.servlet.exception.isEmptyPwdException;
import kr.or.ddit.util.MyUtils;

public class MemberServiceImpl implements MemberService{

	private MemberDao memDao;
	
	private static MemberService service;
	
	private MemberServiceImpl(){
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static MemberService getInstance() {	
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	private SqlSessionFactory SqlSessionFactory = new OracleMyBatisSqlSessionFactory();; 
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.SqlSessionFactory = sqlSessionFactory;
	}
	
//	MyUtils myUtils = MyUtils.getInstance();

	@Override
	public MemberVO login(String id, String pwd) throws NotFoundIDException, InvalidPasswordException, SQLException {
		MemberVO member = null;
		SqlSession session = SqlSessionFactory.openSession(false);
		
			member = memDao.selectMemberByID(session, id);
		if (member != null) {
			if (pwd.equals(member.getPwd())) { // 로그인 성공 
				session.close();
				return member;
			} else { // 패드워드 불일치
				session.rollback(); // 맞는지(?)
				throw new InvalidPasswordException();
			}
		} else {// 아이디 불일치
			session.rollback();
			throw new NotFoundIDException();
		}
	}

	@Override
	public int registerMember(MemberVO memberVo) throws SQLException, isEmptyPwdException, isEmptyIdException {
		SqlSession session = SqlSessionFactory.openSession(false);
		
		// 빈칸
		// 중복검사
		// 정규화
		
		int cnt = -1;
		
		MyUtils myUtils = new MyUtils();
		if (myUtils.isEmpty(memberVo.getId())) {
			throw new isEmptyIdException();
			
		} else if (myUtils.isEmpty(memberVo.getPwd())) {
			throw new isEmptyPwdException();
		}
			
		cnt = memDao.insertMember(session, memberVo);
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		int cnt = -1;
		cnt = memDao.deleteMember(session, memId);
		session.close();
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memberVo) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		int cnt = -1;
		cnt = memDao.updateMember(session, memberVo);
		session.close();
		return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		List<MemberVO> list = null;
		list = memDao.selectAllMember(session);
		session.close();
		return list;
	}

	@Override
	public List<MemberVO> selectMember(MemberVO memberVo) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		List<MemberVO> list = null;
		list = memDao.selectMember(session, memberVo);
		session.close();
		return list;
	}

	@Override
	public MemberVO viewMember(String id) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		MemberVO member = null;
		member = memDao.selectMemberByID(session, id);
		session.close();
		
		return member;
	}


	
}
