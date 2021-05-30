package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MemberDaoImpl implements MemberDao{
	
	private static MemberDao memdao;
	private static OracleMyBatisSqlSessionFactory ssf;
	private SqlSession session;
	
	private MemberDaoImpl() {
		ssf = new OracleMyBatisSqlSessionFactory();
		session = ssf.openSession();
	}
	
	public static MemberDao getInstance() {
		if(memdao == null) {
			memdao = new MemberDaoImpl();
		}
		return memdao;
	}
	
	@Override
	public MemberVO selectMemberByID(SqlSession session, String memId) throws SQLException {
		MemberVO memvo = null;
		memvo = session.selectOne("member.selectMemberByID",memId);
		return memvo;
	}
	
	@Override
	public List<MemberVO> selectAllMember(SqlSession session) throws SQLException {
		List<MemberVO> list = null;
		list = session.selectList("member.selectAllMember");
		return list;
	}
	
	@Override
	public List<MemberVO> selectMember(SqlSession session, MemberVO memberVo) throws SQLException {
		List<MemberVO> list = null;
		list = session.selectList("member.selectMember",memberVo);
		return list;
	}

	@Override
	public int insertMember(SqlSession session, MemberVO memberVo) throws SQLException {
		int cnt = 0;
		Object obj = session.insert("member.insertMember",memberVo);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		int cnt = 0;
		cnt = session.delete("member.deleteMember",memId);
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO memberVo) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("member.updateMember",memberVo);
		
		return cnt;
	}
	
	
}
