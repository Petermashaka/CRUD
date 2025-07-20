package com.example.book.controller;

import com.example.book.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // Temporary in-memory storage
    private Map<Long, Book> booksDatabase = new HashMap<>();
    private Long nextId = 1L;

    // GET all books - NOW RETURNS ACTUAL BOOKS!
    @GetMapping
    public Map<Long, Book> getAllBooks() {
        return booksDatabase;  // Returns all stored books
    }
    //get specific books by id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = booksDatabase.get(id);
        if (book != null) {
            return ResponseEntity.ok().body(book);
        }else  {
            return ResponseEntity.notFound().build();
        }

    }
    // POST to add a new book
    @PostMapping
    public String addBook(@RequestBody Book book) {
        booksDatabase.put(nextId, book);
        return "Added book with ID: " + nextId++;
    }

    //delete book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id) {
        if (booksDatabase.containsKey(id)) {
            booksDatabase.remove(id);
            return ResponseEntity.ok("book with ID: " + id + ", Deleted successfully");

        }else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("book with ID: " + id + " not found!");
        }
        }
}