package com.tomek.domain;

import javax.persistence.*;
import java.util.*;

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

    private Post(){

    }
    public Post(String heading){
        this.heading = heading;
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }


    public List<String> getTags() {
        return tags;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                ", writer=" + writer +
                '}';
    }
}
