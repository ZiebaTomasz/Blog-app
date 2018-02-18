package com.tomek.domain.observer;

import com.tomek.domain.Post;

import java.util.List;

public class SingleNotifier {

    private static final SingleNotifier notifier = new SingleNotifier();

    private SingleNotifier(){}

    public static SingleNotifier getNotifier(){
        return notifier;
    }

    public void notiFyObservers(List<PostObserver> postObservers, Post post){

        postObservers.forEach(postObserver -> System.out.println(postObserver.toString()));
        System.out.println(post.getContent());
    }
}
