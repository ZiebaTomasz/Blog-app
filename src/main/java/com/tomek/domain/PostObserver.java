package com.tomek.domain;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class PostObserver {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Email
    private String email;

    public PostObserver(){

    }

    public PostObserver(String email) {
        this.email = email;
    }

}
