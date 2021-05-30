package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MenuDAO;
import kr.or.ddit.dto.MenuVO;

public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO; // = new MenuDaoImpl(); // -> interface를 주는 이유 : 갈아끼울 수 있기에 // -> 의존주입할꺼라 주석철

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	private SqlSessionFactory SqlSessionFactory; // = new OracleMyBatisSqlSessionFactory(); -> 의존주입할꺼라 주석철

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.SqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<MenuVO> getMainMenuList() throws SQLException {
		// 기존 ibatis라면 적야아 하는 내용
		List<MenuVO> menuList = null;
		SqlSession session = SqlSessionFactory.openSession(false);

		try {
			menuList = menuDAO.selectMainMenu(session);
			
			
			session.commit();
			
		} catch (SQLException e) {
			session.rollback();
			e.printStackTrace();
			throw e;
			
		} finally {
			session.close();
		}
		return menuList;
	}
	
// mybatis라서 줄어든 내용(?)
	
	@Override
	public List<MenuVO> getSubMenuList(String mCode) throws SQLException {
		List<MenuVO> menuList = null;
		SqlSession session = SqlSessionFactory.openSession(false);
		
			menuList = menuDAO.selectSubMenu(session, mCode);
			session.close();
			
		return menuList;
	}

	@Override
	public MenuVO getMenubyMcode(String mCode) throws SQLException {
		MenuVO menu = null;
		SqlSession session = SqlSessionFactory.openSession(false);
		
			menu = menuDAO.selectMenuByMcode(session, mCode);
			session.close();
			
			return menu;
	}
}
