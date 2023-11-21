package com.yourcompany.webpageproject.controller;

import com.yourcompany.webpageproject.model.Book;
import com.yourcompany.webpageproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebpageController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String showBooks(Model model) {
        List<Book> allBooks = bookRepository.findAll();
        model.addAttribute("books", allBooks);
        model.addAttribute("newBook", new Book()); // for the form
        return "book-list"; // assuming your HTML file is named book-list.html
    }

    @PostMapping("/addBook")
    public String addBook(Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }
}
