package com.tomek.service;

import com.tomek.domain.Post;
import com.tomek.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class PostServiceTest {

    PostService postService;
    @Mock
    PostRepository postRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        postService = new PostService(postRepository);
    }

    @Test
    public void allPosts() {
        List<Post> list = postService.allPosts();
        assertEquals(list.size(), 0);
    }

    @Test
    public void postById() {
        String expectedHead = "Super";
        Post post1 = new Post();
        post1.setId(1l);
        post1.setHeading("Super");
        postService.save(post1);
        System.out.println(post1.getId());
        assertEquals(postService.postById(1l).getHeading(), expectedHead);

    }

    @Test
    public void findPostByid() {
    }
}