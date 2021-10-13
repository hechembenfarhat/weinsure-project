package tn.weinsure1.entities;

import java.io.File; 
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class SendEmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to, String topic,String body, File file) throws MessagingException
	{
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom("mohamed.jaoua1@esprit.tn");
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSubject(topic);
		mimeMessageHelper.setText(body,true);
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.addAttachment(file.getName(), file);
		javaMailSender.send(mimeMessage);
		System.out.println("email sent"); 

	}
}