package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MenuVO;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<MenuVO> selectMainMenu(SqlSession session) throws SQLException {
		List<MenuVO> list = session.selectList("Menu-Mapper.selectMainMenu");
		return list;
	}

	@Override
	public List<MenuVO> selectSubMenu(SqlSession session, String mCode) throws SQLException {
		List<MenuVO> list = session.selectList("Menu-Mapper.selectSubMenu", mCode);
		return list;
	}

	@Override
	public MenuVO selectMenuByMcode(SqlSession session, String mCode) throws SQLException {
		MenuVO menu = session.selectOne("Menu-Mapper.selectSubMenuByMcode", mCode);
		return menu;
	}

}
