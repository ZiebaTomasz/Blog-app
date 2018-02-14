package com.tomek;

import com.tomek.domain.Post;
import com.tomek.domain.Writer;
import com.tomek.repository.PostRepository;
import com.tomek.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.spi.CalendarNameProvider;

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

        firstPost.setPostDate(new Date(115, 05, 07, 12, 30));
        firstPost.setWriter(tomek);
        firstPost.setDescription("first post for tests");
        firstPost.setContent("Resources exquisite set arranging moonlight sex him household had. \n" +
                " Months had too ham cousin remove far spirit. She procuring the why performed continual improving.\n" +
                " Civil songs so large shade in cause. Lady an mr here must neat sold. \n" +
                "Children greatest ye extended delicate of. No elderly passage earnest as\n" +
                " in removed winding or. ");
        postRepository.save(firstPost);

        Post secondPost = new Post("Second post");
        secondPost.setPostDate(new Date());
        secondPost.setWriter(susan);
        secondPost.setDescription("second post about nothing");
        secondPost.setContent("Luckily friends do ashamed to do suppose. Tried meant mr smile so. \n" +
                "Exquisite behaviour as to middleton perfectly. Chicken no wishing waiting am. Say concerns\n" +
                " dwelling graceful six humoured. Whether mr up savings talking an. Active mutual nor\n" +
                " father mother exeter change six did all. ");
        postRepository.save(secondPost);
    }
}
