package com.tomek.domain.observer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class PostObserver {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    public PostObserver(){

    }

    public PostObserver(String email) {
        this.email = email;
    }

}
