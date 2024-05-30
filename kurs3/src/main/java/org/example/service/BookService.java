package org.example.service;

import org.example.model.Book;
import org.example.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Page<Book> getAll(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

    public Page<Book> search(String text, Pageable pageable) {
        return bookRepo.findByText(text, pageable);
    }

    public Book getById(String id) {
        return bookRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found"));
    }

    public Book add(Book book) {
        return bookRepo.save(book);
    }
}
