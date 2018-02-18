package com.tomek.repository;

import com.tomek.domain.observer.PostObserver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostObserverRepository extends CrudRepository<PostObserver, Long> {

    List<PostObserver> findAll();

}
