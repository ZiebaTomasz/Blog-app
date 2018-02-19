package com.tomek.service;

import com.tomek.domain.PostObserver;
import com.tomek.repository.PostObserverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostObserverService {

    PostObserverRepository postObserverRepository;

    @Autowired
    public PostObserverService(PostObserverRepository postObserverRepository) {
        this.postObserverRepository = postObserverRepository;
    }

    public List<PostObserver> getAllObservers(){
        return postObserverRepository.findAll();
    }

    public PostObserver save(PostObserver postObserver){
        return postObserverRepository.save(postObserver);
    }
}
