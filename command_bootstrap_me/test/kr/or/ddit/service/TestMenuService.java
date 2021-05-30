package kr.or.ddit.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MenuVO;

public class TestMenuService {
	
	private MenuServiceImpl service;
	
	
	@Before
	public void init() {
		
		
		
		service.setMenuDAO(new MockMenuDAO()); // DAO를 Mock으로 세팅
	}
	
	@Test
	public void test() throws Exception{
		System.out.println("구분3");
		List<MenuVO> menuList = service.getSubMenuList("M010000");
		
		Assert.assertEquals(1, menuList.size());
		Assert.assertEquals("회원가입", menuList.get(0).getMname());
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
}
