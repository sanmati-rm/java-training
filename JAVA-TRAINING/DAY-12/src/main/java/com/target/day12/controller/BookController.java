package com.target.day12.controller;

import com.target.day12.BookService;
import com.target.day12.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public Iterable<Book> handleGetBooks(){

        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book handleGetBookByID(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

}
