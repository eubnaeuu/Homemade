package com.spring.service.member;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.command.pagemaker.Criteria;
import com.spring.command.pagemaker.PageMaker;
import com.spring.command.pagemaker.SearchCriteria;
import com.spring.dao.member.MemberDAO;
import com.spring.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	

	
	@Override
	public void login(String id, String pwd) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {

		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList = memberDAO.selectMemberList();
		return memberList;
	}

	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws SQLException {
		List<MemberVO> memberList = memberDAO.selectMemberList(cri);
		return memberList;
	}

	@Override
	public Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException {

		Map<String, Object> dataMap = new HashMap<String, Object>();

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberDAO.selectMemberListCount(cri));

		List<MemberVO> memberList = memberDAO.selectMemberList(cri);

		dataMap.put("memberList", memberList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {

		memberDAO.insertMember(member);
	}

	@Override
	public void modify(MemberVO member) throws SQLException {

	}

	@Override
	public void remove(String id) throws SQLException {

		memberDAO.deleteMember(id);

	}

	@Override
	public void disabled(String id) throws SQLException {

		memberDAO.disabledMember(id);

	}

	@Override
	public void enabled(String id) throws SQLException {

		memberDAO.enabledMember(id);
	}

}












