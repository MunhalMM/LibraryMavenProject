package org.project.controller;

import org.project.model.Book;
import org.project.service.BookService;

import java.util.List;

public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getAll() {
        return bookService.getAll();
    }

    public Book getBook(int id) {
        return bookService.getBook(id);
    }

    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public void deleteBookFromLibrary(Book book) {
        bookService.remove(book);
    }
}
