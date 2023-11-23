/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vogiadat
 */
public class Authentication {

	public void OTP_Email(String mail) {
		String from = "ngocnienvc@gmail.com";
		String to = mail;
		String host = "smtp.gmail.com";
		Random rand = new Random();
		int key = rand.nextInt(900000) + 100000;
		int otp = key;

		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("ngocnienvc@gmail.com", "hpxq vrgb ebtt kcor");

			}

		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("MÃ OTP CỦA FEN LÀ :");

			message.setContent("<h1>" + key + "</h1>", "text/html");
			Transport.send(message);
			JOptionPane.showMessageDialog(null, "Đã gửi mã xác thực, hãy kiểm tra mail của bạn!");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}
}
