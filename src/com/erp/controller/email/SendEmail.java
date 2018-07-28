package com.erp.controller.email;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.servlet.http.HttpServletRequest;

import java.util.Properties;

@Controller
@RequestMapping(value = "se")
public class SendEmail {

    private String SMTP_HOST_NAME = "mail.sarinagp.com";
    private String SMTP_AUTH_USER = "test@sarinagp.com";
    private String SMTP_AUTH_PWD  = "Arsham910@";

    @RequestMapping(value = "registerEmail.do")
    public String sendEmail(HttpServletRequest request ) throws MessagingException {

        /* generate random number for verification*/
        String num = String.valueOf(Math.random());


        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", SMTP_HOST_NAME);
        properties.put("mail.smtp.auth", "true");

        Authenticator authenticator = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(properties, authenticator);
        // uncomment for debugging infos to stdout
        // mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setContent("This is a test", "text/plain");
        message.setFrom(new InternetAddress("test@sarinagp.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress("info@test.com"));

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
        request.getSession().setAttribute("verifyCode",num.substring(2,7));
        return "index";
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
    public String generateNumber()
    {
        String num = String.valueOf(Math.random());
        return num.substring(2,7);
    }
}
