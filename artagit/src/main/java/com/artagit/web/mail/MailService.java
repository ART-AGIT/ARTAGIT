package com.artagit.web.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SpringTemplateEngine templateEngine;

	
    /**
     * 이메일 발송 함수
     * @param title 이메일 제목
     * @param to 받는 사람
     * @param templateName 이메일 템플릿
     * @param values 이메일에 들어가는 값
     * @throws MessagingException
     * @throws IOException
     */
	
	// 임시 비밀번호 메일 설정
	public void sendMail(@PathVariable String email, String memId, String tmpPwd) throws Exception{
		
		MimeMessage message = mailSender.createMimeMessage();
		
		System.out.println("mail서비스로 전달받은 tmpPwd ===> "+tmpPwd);
		System.out.println("mail서비스로 전달받은 id ===> "+memId);

//		email = "ghqkd333@naver.com";
		message.addRecipients(MimeMessage.RecipientType.TO, email); // 보낼 이메일 설정
			System.out.println("여기까지");
		message.setSubject("[Art Agit] 임시 비밀번호 안내 이메일입니다."); // 이메일 제목
		message.setFrom(new InternetAddress("lucky_belief@naver.com", "Art Agit")); // 보내는 사람 이름 설정하고 싶은 경우
		message.setText(setContext(memId, tmpPwd), "utf-8", "html"); // 내용 설정(Template Process)
			System.out.println("여기까지222");
        
        mailSender.send(message); // 이메일 전송
		
        System.out.println("메일 발송 성공");
	}
	
	// 타임리프 설정하는 코드
	private String setContext(String memId, String tmpPwd) {
        Context context = new Context();
        context.setVariable("id", memId); // Template에 전달할 데이터 설정
        context.setVariable("tmpPwd", tmpPwd); 
        System.out.println("setContext의 memId는 ===> " + memId);
        System.out.println("setContext의 tmpPwd는 ===> " + tmpPwd);
        
        return templateEngine.process("mail/mail", context); // mail.html 
    }
	
    // 랜덤함수로 임시비밀번호 생성하기
    public String getTmpPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        							'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
        							'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
        							'W', 'X', 'Y', 'Z' };
        String pwd = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 조합
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            pwd += charSet[idx];
        }
        System.out.println("임시 비밀번호(" + pwd + ") 생성 완료");
        return pwd;
    }
}
