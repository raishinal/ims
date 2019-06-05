/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.utils;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

/**
 *
 * @author Raishin
 */
public class MailSender {
    public static boolean sendMail(String to,String sub,StringBuilder msg){
        boolean msgSent = false;
        //get properties object
        Properties props=new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465"); //ssl
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");
        //get Session
        Session session=Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("roslmggac@gmail.com","rakudai13");
            }
        });
        //compose message
        try{
            MimeMessage message= new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg.toString());
            //send message
            Transport.send(message);
            msgSent=true;
        }
        catch(MessagingException e){
//            throw new RuntimeException(e);
            System.out.println(e);
        }
        return msgSent;
    }
}
