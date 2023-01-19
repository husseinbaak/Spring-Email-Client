package com.husseinbaak.SpringEmailClient.email;

import javax.mail.MessagingException;

public interface EmailServices {

    void sendSimpleEmail(String toEmail,
                         String body,
                         String subject);

    void  sendEmailWithAttachment(String toEmail,
                                  String body,
                                  String subject,
                                  String attachment) throws MessagingException;
}
