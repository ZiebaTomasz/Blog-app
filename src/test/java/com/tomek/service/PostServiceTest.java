package com.tomek.service;

import com.tomek.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostServiceTest {

    private final String exprectedHead = "head";


    @Autowired
    private PostRepository postRepository;

    @Test
    public void findPostByid() throws Exception {
        assertEquals(postRepository.findOne(1L), exprectedHead);

    }

}