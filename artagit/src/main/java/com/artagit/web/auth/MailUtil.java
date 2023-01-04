package com.artagit.web.auth;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;

public class MailUtil {
	
	@Autowired
//	UserService service;
	
	public static void sendMail(String email, String subject, String msg) throws Exception {
		
		// Mail Server Setting
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";   // SMTP 서버명
		String hostSMTPid = "lucky_belief";   // 아이디
		String hostSMTPpwd = "artagit0823";   // 비밀번호
		
		// 보내는 사람
		String fromEmail = "help@artagit.com";	// 보내는 사람 이메일
		String fromName = "ARTAGIT";			// 보내는 사람 이름
	
		// email 전송
		try {
			HtmlEmail mail = new HtmlEmail();
			mail.setDebug(true);
			mail.setCharset(charSet);
			mail.setSSLOnConnect(true);	
			mail.setHostName(hostSMTP);
			mail.setSmtpPort(587);
			mail.setAuthentication(hostSMTPid, hostSMTPpwd);
			mail.setStartTLSEnabled(true);
			mail.addTo(email);
			mail.setFrom(fromEmail, fromName, charSet);
			mail.setSubject(subject);
			mail.setHtmlMsg(msg);
			mail.send();	
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
