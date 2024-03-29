package com.husseinbaak.SpringEmailClient.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSendService implements EmailServices {
    // JavaMailSender hazir sinif kullanarak
    // mailSender.send(message); userinde islem gerceklesir
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject){
        SimpleMailMessage message  =new SimpleMailMessage();
        message.setFrom("hussein.seyh@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send ..... ");
    }

    @Override
    public void  sendEmailWithAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                =new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setFrom("hussein.seyh@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem=new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystem.getFilename(),fileSystem);
        mailSender.send(mimeMessage);
        System.out.println("Mail Send...");



    }
}
