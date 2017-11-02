package web.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.MemberDao;
import web.db.vo.Member;
import web.query.vo.QueryUpdate;

@Service
@Transactional
public class MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	MemberDao dao;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	public boolean insertMember(Member member) {
		logger.info("진입");
		
		return dao.insertMember(member);
	}
	

	/*************************************************
	 * 					READ
	 * ***********************************************/
	public Member getUser(Member user) {
		logger.info("진입");
		return dao.getUser(user);
	}
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/


	public List<Member> getMemberList(String column, String scending, String query) {
		return dao.getMemberList(column, scending, query);
	}


	public List<Member> getMemberSearchList(String column, String query) {
		return dao.getMemberSearchList(column, query);
	}


	public Member getMember(int memberNoInt) {
		return dao.getMember(memberNoInt);
	}


	public boolean updateMember(QueryUpdate query) {
		return dao.updateMember(query);
	}


	public boolean deleteMember(Member member) {
		return dao.deleteMember(member);		
	}

}