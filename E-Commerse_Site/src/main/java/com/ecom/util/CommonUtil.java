package com.ecom.util;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class CommonUtil {
	
	@Autowired
	private JavaMailSender mailSender;

	public Boolean sendMail(String url,String recipientEmail) throws UnsupportedEncodingException, MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		
		helper.setFrom("tejasthawri@gmail.com", "Shopping cart");
		helper.setTo(recipientEmail);
		
		String Content = "<p>Hello, </p>"+ "<p>You have Request to Reset Password.</p>"
		+ "<p>Click the link below to change your password : </p>"+ "<p><a href=\"" + url 
		+ "\">Change My Password</a></p>";
		
		
		helper.setSubject("Password Reset");
		helper.setText(Content,true);
		mailSender.send(mimeMessage);
		
		return true;
	}

	public static String generateUrl(HttpServletRequest request) {

		// http://localhost:8080/forgot-password
		String siteUrl = request.getRequestURL().toString();

		return siteUrl.replace(request.getServletPath(), "");
	}
}
