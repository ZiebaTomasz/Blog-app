package com.tomek.service.mailService;

import com.tomek.domain.Post;
import com.tomek.domain.observer.PostObserver;

import java.util.List;

public interface PreparingEmailNotification {

    void sendEmailsToObservers (Post newPost, List<PostObserver> postObserverList);

    String prepareEmail(Post newPost, List<PostObserver> postObserverList);
}
