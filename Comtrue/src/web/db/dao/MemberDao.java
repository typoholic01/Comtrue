package web.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.db.vo.Member;
import web.query.vo.QueryList;
import web.query.vo.QueryUpdate;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	private static final String ns = "Members.";
	
	@Autowired
	SqlSession session;	

	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	public boolean insertMember(Member member) {
		logger.info("진입");
		
		logger.info(member.toString());
		
		return session.insert(ns+"insertMember", member) > 0 ? true:false;
	}
	

	/*************************************************
	 * 					READ
	 * ***********************************************/
	public Member getUser(Member user) {
		logger.info("진입");
		return session.selectOne(ns+"getUser", user);
	}
	

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/

	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	public boolean deleteUser(Member user) {
		logger.info("진입");
		
		//init
		int n = 0;
		
		try {
			n = session.delete(ns+"deleteUser", user);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		return n > 0 ? true:false;
	}


	public List<Member> getMemberList(String column, String scending, String query) {
		
		//init
		QueryList queryList = new QueryList();
		
		//Set Query
		queryList.setColumn(column);
		queryList.setScending(scending);
		queryList.setQuery(query);
		
		logger.info(queryList.toString());
		
		//run
		return session.selectList(ns+"getMemberList", queryList);
	}


	public List<Member> getMemberSearchList(String column, String query) {

		//init
		QueryList queryList = new QueryList();
		
		//Set Query
		queryList.setColumn(column);
		queryList.setQuery(query);
		
		
		
		return session.selectList(ns+"getMemberSearchList", queryList);
	}


	public Member getMember(int memberNo) {
		return session.selectOne(ns+"getMember", memberNo);
	}


	public boolean updateMember(QueryUpdate query) {
		logger.info("진입");
		
		logger.info(query.toString());
		
		return session.update(ns+"updateMember", query) > 0 ? true : false;
	}


	public boolean deleteMember(Member member) {
		return session.delete(ns+"deleteMember", member) > 0 ? true : false;
	}

}
