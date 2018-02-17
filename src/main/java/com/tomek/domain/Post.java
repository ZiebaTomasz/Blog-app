package com.tomek.domain;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String heading;

    @Lob
    private String description;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;

    @ManyToOne
    private Writer writer;


    @ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
    private List<String> tags = new ArrayList<>();

    public Post(){
        this.postDate = new Date();
    }

    public Post(String heading){
        this.heading = heading;
    }

    public void addTag(String tag){
        tags.add(tag);
    }


}
