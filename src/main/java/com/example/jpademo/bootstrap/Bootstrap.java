package com.example.jpademo.bootstrap;

import com.example.jpademo.model.Author;
import com.example.jpademo.model.Book;
import com.example.jpademo.model.Genre;
import com.example.jpademo.model.Publisher;
import com.example.jpademo.repository.AuthorRepository;
import com.example.jpademo.repository.BookRepository;
import com.example.jpademo.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Component
public class Bootstrap implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Publisher p1 = new Publisher();
        p1.setName("Wily");
        Author a1 = new Author();
        a1.setName("Kafka");
        Author a2 = new Author();
        a2.setName("Tolstoy");
        Book b1 = new Book();
        b1.setTitle("The Castle");
        b1.setAuthorList(Collections.singletonList(a1));
        b1.setGenre(Genre.NOVEL);
        b1.setPublisher(p1);
        Book b2 = new Book();
        b2.setTitle("War & Peace");
        b2.setGenre(Genre.NOVEL);
        b2.setAuthorList(Collections.singletonList(a2));
        b2.setPublisher(p1);
        a1.setBookList(Arrays.asList(b1));
        a2.setBookList(Arrays.asList(b2));
        p1.setBookList(Arrays.asList(b1, b2));

        bookRepository.save(b1);
        bookRepository.save(b2);

        bookRepository.delete(b1);

    }
}
