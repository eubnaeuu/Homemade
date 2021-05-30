package kr.or.ddit.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestOracleMyBatisSqlSessionFactory {

	private SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
	private SqlSession session;
	
	@Before
	public void openSession () {
		session = factory.openSession(); 
	}
	
	@Test
	public void testSqlSession() throws Exception{
		Assert.assertNotNull(session.getConnection());
	}
	
	@After
	public void testSql() throws Exception{
		MemberVO memVo = new MemberVO();
		List <MemberVO> list = session.selectList("member.selectMember",memVo);
		Assert.assertEquals(null, list);
		
	}
}
