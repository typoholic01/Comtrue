package web.scheduler.job;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSend implements Job {
	
   @Autowired
   private JavaMailSender mailSender;
	   
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

        String setfrom = "typoholic01@gmail.com";  // 보내는사람       
         String tomail  = "typoholic01@gmail.com";     // 받는 사람 이메일
         String title   = "KH대학교 비밀번호 입니다";      // 제목
         String content = "KH대학교 찾으시는 해당 비밀번호는 :  입니다";    // 내용
         
         SimpleMailMessage message = new SimpleMailMessage();

         message.setFrom(setfrom);  
         message.setTo(tomail);    
         message.setSubject(title);
         message.setText(content);
         
         mailSender.send(message);
	}

}
