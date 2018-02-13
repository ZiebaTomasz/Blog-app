package com.tomek;

import com.tomek.domain.Post;
import com.tomek.domain.Writer;
import com.tomek.repository.PostRepository;
import com.tomek.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.invoke.WrongMethodTypeException;

@Component
public class Database {

    private PostRepository postRepository;
    private WriterRepository writerRepository;

    @Autowired
    public Database(PostRepository postRepository, WriterRepository writerRepository) {
        this.postRepository = postRepository;
        this.writerRepository = writerRepository;
    }

    @PostConstruct
    private void loadData(){
        Writer tomek = new Writer("Tomek","Z.", "ziebatomasz3gmail.com");
        Writer billy = new Writer("Bily", "Kid","BillyKid@mail.com");
        Writer susan = new Writer("Susan", "Kenedy","susan@mail.com");

        writerRepository.save(tomek);
        writerRepository.save(billy);
        writerRepository.save(susan);

        Post firstPost = new Post("First post");
        firstPost.setWriter(tomek);
        firstPost.setDescription("first post for tests");

        postRepository.save(firstPost);
    }
}
