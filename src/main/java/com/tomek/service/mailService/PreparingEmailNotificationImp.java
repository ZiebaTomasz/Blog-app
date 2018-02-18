package com.tomek.service.mailService;

import com.tomek.domain.Post;
import com.tomek.domain.observer.PostObserver;

import java.util.List;

public class PreparingEmailNotificationImp implements PreparingEmailNotification {

    @Override
    public void sendEmailsToObservers(Post newPost, List<PostObserver> postObserverList) {

        prepareEmail(newPost,postObserverList);

    }

    @Override
    public String prepareEmail(Post newPost, List<PostObserver> postObserverList) {
        String emailContent = "There is a new post " + newPost.getWriter().getFirstName()+
                " "+ newPost.getWriter().getLastName()+"with the title: " + newPost.getHeading()+
                ". For more detail visit our blog";

        return emailContent;
    }
}
