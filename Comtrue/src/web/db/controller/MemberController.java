package web.db.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import web.db.service.MemberService;
import web.db.vo.Member;
import web.query.vo.QueryUpdate;
import web.view.util.CSVWrite;
import web.view.util.XLSWrite;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	   
	@Autowired
	MemberService serv;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/	
	//직원 등록 화면
	@RequestMapping(value= "/member/account",method=RequestMethod.GET)
	public String account() {
		logger.info("진입");
		
		return "/member/account";
	}
	
	//직원 등록 기능
	@RequestMapping(value= "/member/account",method=RequestMethod.POST)
	public String accountPost(Member member) {
		logger.info("진입");
		
		logger.info(member.toString());
		
		//run
		try {
			serv.insertMember(member);				
		} catch (Exception e) {
			return "/member/accountFail";			
		}

		return "/member/list";
	}	
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//메인 화면
	@RequestMapping(value= "/",method=RequestMethod.GET)
	public String home() {
		logger.info("진입");
				
		return "/member/list";
	}
	
	//직원 목록 화면
	@RequestMapping(value= "/member/list",method=RequestMethod.GET)
	public String memberList() {
		logger.info("진입");
		
		return "/member/list";
	}
	
	//직원 조회 기능
	@RequestMapping(value= "/member/list/json",method=RequestMethod.GET)
	public @ResponseBody List<Member> list(String column, String scending, String query) {
		logger.info("진입");
		
		//init
		List<Member> memberList;
		
		//FIX
		column = getColumn(column);
		scending = getScending(scending);
		
		memberList = serv.getMemberList(column, scending, query);

		return memberList;
	}

	//직원 목록 다운로드
	@RequestMapping(value= "/member/list/csv",method=RequestMethod.GET)
	public @ResponseBody String csvList(HttpServletRequest req) {
		logger.info("진입");

		//init
		List<Member> memberList;
        List<String[]> data = new ArrayList<String[]>();
        String path;
		
        //run
		memberList = serv.getMemberList("name", "desc", "");
		
		//data setup
		for (Member member : memberList) {
	        data.add(new String[] { 
	        		String.valueOf(member.getMemberNo()), 
	        		member.getRank(), 
	        		member.getName(), 
	        		member.getPhone(), 
	        		member.getEmail() 
    		});
		}
        
        //파일 저장경로
        path = req.getSession().getServletContext().getRealPath("/") + "upload/csv/";
        logger.info(path);
		
        //CSV Save
        CSVWrite cw = new CSVWrite(path);
        cw.writeCsv(data);

		return cw.getFileName();
	}
	
	//직원 XLS 다운로드
	@RequestMapping(value= "/member/list/xls",method=RequestMethod.GET)
	public @ResponseBody String xlsList(HttpServletRequest req) {
		logger.info("진입");

		//init
		List<Member> memberList;
        List<String[]> data = new ArrayList<String[]>();
        String path;
		
        //run
		memberList = serv.getMemberList("name", "desc", "");
		
		//Data setup
		for (Member member : memberList) {
	        data.add(new String[] { 
        		String.valueOf(member.getMemberNo()), 
        		member.getRank(), 
        		member.getName(), 
        		member.getPhone(), 
        		member.getEmail() 
    		});
		}
		
		//파일 저장경로
		path = req.getSession().getServletContext().getRealPath("/") + "upload/xls/";
	    logger.info(path); 														
	        
	    //XLS Save
        XLSWrite xw = new XLSWrite(path);
        xw.writeXLS(data);

		return xw.getFileName();
	}

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	//직원 수정 화면
	@RequestMapping(value= "/member/update",method=RequestMethod.GET)
	public String memberUpdate(String memberNo, Model model) {
		logger.info("진입");
		
		//init
		Member member;
		int memberNoInt = Integer.parseInt(memberNo);
		
		//run
		member = serv.getMember(memberNoInt);
		
		//set
		model.addAttribute("member", member);
		
		return "/member/update";
	}
	
	//직원 수정 기능
	@RequestMapping(value= "/member/update",method=RequestMethod.POST)
	public String memberUpdatePOST(QueryUpdate query, Model model) {
		logger.info("진입");
		
		serv.updateMember(query);
		
		return "/member/list";
	}
	

	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//직원 삭제
	@RequestMapping(value= "/member/delete",method=RequestMethod.GET)
	public String deleteMember(Member member) {
		logger.info("진입");
		
		serv.deleteMember(member);
		
		return "/member/list";
	}
	
	/************************************************************
	 * 							Util Method 
	 * **********************************************************/	
	private String getColumn(String column) {
		
		if (column == null || column.equals("")) {
			column = "name";
		}
		
		return column;
	}	
	private String getScending(String scending) {
		
		if (scending == null || scending.equals("")) {
			scending = "desc";
		}
		
		return scending;
	}

}