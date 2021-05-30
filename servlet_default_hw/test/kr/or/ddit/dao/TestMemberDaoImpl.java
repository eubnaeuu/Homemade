package kr.or.ddit.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import junit.framework.Assert;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMemberDaoImpl {
	
	private SqlSession session;
	private MemberDao memberDao;
	
	
//	@BeforeClass
//		public void init() {
//			session = new OracleMyBatisSqlSessionFactory().openSession(false);
//			memberDao = new MemberDaoImpl();
//	}
//	@Test
//		public void test() {
//			MemberVO memberVo = new MemberVO();
//			memberVo = memberDao.selectMemberByID(session, "lala");
//			Assert.assertEquals("lala",memberVo.getName());
//			
//	}
//	
//	
//	
//	@AfterClass
//		public void success() {
//			session.rollback();
//			session.close();
//	}
	
}
