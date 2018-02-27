package com.tomek.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostTest {

    Post post;

    @Before
    public void setUp(){
        post = new Post();
    }

    @Test
    public void getId() {
        Long idValue = 1l;
        post.setId(1l);
        assertEquals(idValue, post.getId());
    }

    @Test
    public void getHeading() {
        String head = "Nice";
        post.setHeading("Nice");
        assertEquals(head,post.getHeading());
    }

    @Test
    public void getDescription() {
        String head = "very nice";
        post.setDescription("very nice");
        assertEquals(head,post.getDescription());
    }

    @Test
    public void getContent() {
        String head = "content";
        post.setHeading("content");
        assertEquals(head,post.getContent());

    }

    @Test
    public void getWriter() {
        Writer writer = new Writer();
        writer.setFirstName("Tom");
        post.setWriter(writer);
        assertEquals(writer.getFirstName(),post.getWriter().getFirstName());
    }
}