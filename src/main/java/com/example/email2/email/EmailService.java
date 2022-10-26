package com.example.email2.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendTo(String email,String title, String text) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setSubject(title);
        helper.setTo(email);

        boolean html = true;
        String textHtml= "<h1>" +title+"</h1><h2></h2>" +
                "<img src=https://img.freepik.com/foto-gratis/imagen-primer-plano-hierba-verde-fresca-primavera_1232-2759.jpg?w=1060&t=st=1666774005~exp=1666774605~hmac=685901089a672e89bdb3e66672eb1727a4d0f5302f17df8873116d047e9059b2 >" +
                "<h3>"+text+"</h3>";
        helper.setText(textHtml, html);

        javaMailSender.send(message);
    }

}
