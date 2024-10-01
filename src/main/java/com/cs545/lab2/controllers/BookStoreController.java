package com.cs545.lab2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs545.lab2.domain.Book;

@RestController
@RequestMapping
public class BookStoreController {

    private static List<Book> myBooks = new ArrayList<>(List.of(
            new Book(1, "Book 1", "ISBN 1", 20.0),
            new Book(2, "Book 2", "ISBN 2", 30.0),
            new Book(3, "Book 3", "ISBN 3", 40.0)));

    // <--------------------- URI versioning ------------------------>
    @GetMapping("/v1/books")
    public List<Book> getAllBooksURI() {
        return myBooks;
    }

    @GetMapping("/v1/books/{id}")
    public Book getbookByIdURI(
            @PathVariable int id) {

        return myBooks.stream().filter(book -> book.getId() == id).findFirst().orElse(null);

    }

    @PostMapping("/v1/books")
    public List<Book> createBookURI(@RequestBody Book book) {
        System.out.println("Book: " + book);
        myBooks.add(book);
        return myBooks;
    }

    @PutMapping("v1/books/{id}")
    public List<Book> updateBookURI(@PathVariable String id, @RequestBody Book updBook) {
        myBooks.stream().filter(book -> book.getId() == Integer.parseInt(id)).findFirst().ifPresent(book -> {
            book.setTitle(updBook.getTitle());
            book.setIsbn(updBook.getIsbn());
            book.setPrice(updBook.getPrice());
        });
        return myBooks;
    }

    @DeleteMapping("v1/books/{id}")
    public List<Book> deleteBookURI(@PathVariable String id) {
        myBooks.removeIf(book -> book.getId() == Integer.parseInt(id));
        return myBooks;
    }

    // <--------------------- Media type versioning ------------------------>

    @GetMapping(value = "/books", produces = "application/cs.miu.edu-v2+json")
    public List<Book> getAllBooksMediVer() {
        return myBooks;
    }

    @GetMapping(value = "/books/{id}", produces = "application/cs.miu.edu-v2+json")
    public Book getbookByIdMediVer(
            @PathVariable int id) {

        return myBooks.stream().filter(book -> book.getId() == id).findFirst().orElse(null);

    }

    @PostMapping(value = "/books", produces = "application/cs.miu.edu-v2+json")
    public List<Book> createBookMediVer(@RequestBody Book book) {
        System.out.println("Book: " + book);
        myBooks.add(book);
        return myBooks;
    }

    @PutMapping(value = "/books/{id}", produces = "application/cs.miu.edu-v2+json")
    public List<Book> updateBookMediVer(@PathVariable String id, @RequestBody Book updBook) {
        myBooks.stream().filter(book -> book.getId() == Integer.parseInt(id)).findFirst().ifPresent(book -> {
            book.setTitle(updBook.getTitle());
            book.setIsbn(updBook.getIsbn());
            book.setPrice(updBook.getPrice());
        });
        return myBooks;
    }

    @DeleteMapping(value = "/books/{id}", produces = "application/cs.miu.edu-v2+json")
    public List<Book> deleteBookMediVer(@PathVariable String id) {
        myBooks.removeIf(book -> book.getId() == Integer.parseInt(id));
        return myBooks;
    }

    // <--------------------- (Custom) header versioning ------------------------>

    @GetMapping(value = "/books", headers = "X-API-VERSION=2")
    public List<Book> getAllBooksCustomVer() {
        return myBooks;
    }

    @GetMapping(value = "/books/{id}", headers = "X-API-VERSION=2")
    public Book getbookByIdCustomVer(
            @PathVariable int id) {

        return myBooks.stream().filter(book -> book.getId() == id).findFirst().orElse(null);

    }

    @PostMapping(value = "/books", headers = "X-API-VERSION=2")
    public List<Book> createBookCustomVer(@RequestBody Book book) {
        System.out.println("Book: " + book);
        myBooks.add(book);
        return myBooks;
    }

    @PutMapping(value = "/books/{id}", headers = "X-API-VERSION=2")
    public List<Book> updateBookCustomVer(@PathVariable String id, @RequestBody Book updBook) {
        myBooks.stream().filter(book -> book.getId() == Integer.parseInt(id)).findFirst().ifPresent(book -> {
            book.setTitle(updBook.getTitle());
            book.setIsbn(updBook.getIsbn());
            book.setPrice(updBook.getPrice());
        });
        return myBooks;
    }

    @DeleteMapping(value = "/books/{id}", headers = "X-API-VERSION=2")
    public List<Book> deleteBookCustomVer(@PathVariable String id) {
        myBooks.removeIf(book -> book.getId() == Integer.parseInt(id));
        return myBooks;
    }

    // <--------------------- Request Parameter versioning ------------------------>

    @GetMapping(value = "/books", params = "version=1")
    public List<Book> getAllBooksParameterVer() {
        return myBooks;
    }

    @GetMapping(value = "/books/{id}", params = "version=1")
    public Book getbookByIdParameterVer(
            @PathVariable int id) {

        return myBooks.stream().filter(book -> book.getId() == id).findFirst().orElse(null);

    }

    @PostMapping(value = "/books", params = "version=1")
    public List<Book> createBookParameterVer(@RequestBody Book book) {
        System.out.println("Book: " + book);
        myBooks.add(book);
        return myBooks;
    }

    @PutMapping(value = "/books/{id}", params = "version=1")
    public List<Book> updateBookParameterVer(@PathVariable String id, @RequestBody Book updBook) {
        myBooks.stream().filter(book -> book.getId() == Integer.parseInt(id)).findFirst().ifPresent(book -> {
            book.setTitle(updBook.getTitle());
            book.setIsbn(updBook.getIsbn());
            book.setPrice(updBook.getPrice());
        });
        return myBooks;
    }

    @DeleteMapping(value = "/books/{id}", params = "version=1")
    public List<Book> deleteBookParameterVer(@PathVariable String id) {
        myBooks.removeIf(book -> book.getId() == Integer.parseInt(id));
        return myBooks;
    }

}
