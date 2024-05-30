package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getIndex(Model model) {
        Page<Book> bookPage = bookService.getAll(Pageable.ofSize(10));
        model.addAttribute("bookPage", bookPage);
        return "index";
    }

    @PostMapping("/")
    public String postIndex(Model model, String searchStr) {
        Page<Book> bookPage = bookService.search(searchStr, Pageable.ofSize(10));
        model.addAttribute("bookPage", bookPage);
        return "index";
    }

    @GetMapping("/add")
    public String getAdd() {
        return "add";
    }

    @PostMapping("/add")
    public String addBook(Book book) {
        bookService.add(book);
        return "redirect:/";
    }

    @GetMapping("/info/{id}")
    public String getInfo(Model model, @PathVariable("id") String id) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "info";
    }
}
