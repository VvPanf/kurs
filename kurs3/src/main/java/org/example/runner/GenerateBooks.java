package org.example.runner;

import com.github.javafaker.Faker;
import org.example.model.Book;
import org.example.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenerateBooks implements CommandLineRunner {
    @Autowired
    private BookRepo bookRepo;

    private Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<10; i++) {
            bookRepo.save(new Book(null, faker.book().title(), faker.number().numberBetween(1900, 2000), faker.lorem().characters(100, 1000)));
        }
    }
}
