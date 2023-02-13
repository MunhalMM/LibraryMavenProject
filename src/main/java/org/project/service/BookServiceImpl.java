package org.project.service;

import org.project.model.Book;
import org.project.repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.getBook(id);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public void remove(Book book) {
        bookRepository.removeBook(book);
    }
}
