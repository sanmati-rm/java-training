package com.target.day12;

import com.target.day12.entity.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BookService {

    Map<Integer, Book> books = new LinkedHashMap<>();

    public BookService(){
        Book b1,b2,b3;
        b1 = new Book(1,"Harry Potter", Arrays.asList("J.K Rowling"),500.0, 1000);
        b2 = new Book(2,"Harry Potter 2", Arrays.asList("J.K Rowling"),500.0, 1000);
        b3 = new Book(3,"Harry Potter and The Cursed Child", Arrays.asList("J.K Rowling"),500.0, 1000);

        books.put(1,b1);
        books.put(2,b2);
        books.put(3,b3);
    }

    public Iterable<Book> getAllBooks(){
        return books.values();
    }

    public Book getBookById(Integer id){
        return books.get(id);
    }
}
