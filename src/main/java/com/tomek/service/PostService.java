package com.tomek.service;

import com.tomek.domain.Post;
import com.tomek.repository.PostRepository;
import com.tomek.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    public Post postById(Long id) {
        return postRepository.findOne(id);
    }

    public void deletePostById(Long id) {
        postRepository.delete(id);
    }

    public List<Post> findPostByid(Long id) {
        return postRepository.findAllByWriterId(id);
    }

    public Post save(Post post){
        return postRepository.save(post);
    }

}
