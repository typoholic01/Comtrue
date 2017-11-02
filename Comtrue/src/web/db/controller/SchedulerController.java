package web.db.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SchedulerController {
	private static final Logger logger = LoggerFactory.getLogger(SchedulerController.class);
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/	
	//직원 등록 화면
	@RequestMapping(value= "/member/test",method=RequestMethod.GET)
	public String sendEmail() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		logger.info("진입");

        String setfrom = "typoholic01@gmail.com";  // 보내는사람       
		String tomail  = "typoholic01@gmail.com";     // 받는 사람 이메일
		String title   = "테스트입니다";      // 제목
		String content = "TESTTESTtesttest";    // 내용
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(setfrom);  
		message.setTo(tomail);    
		message.setSubject(title);
		message.setText(content);
		 
		mailSender.send(message);
         
		return "/member/list";
	}
}
