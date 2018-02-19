package com.tomek.service;

import com.tomek.domain.Post;
import com.tomek.domain.PostObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) throws MailException {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Post savedPost, List<PostObserver> allObservers){


        for (PostObserver postObserver : allObservers){

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(postObserver.getEmail());
            message.setFrom("tomek526@gmail.com");
            message.setSubject(savedPost.getHeading());
            message.setText("There is a new post posted by "+ savedPost.getWriter().getFirstName()+". \nVisit our site!");

            javaMailSender.send(message);
        }

    }
}
