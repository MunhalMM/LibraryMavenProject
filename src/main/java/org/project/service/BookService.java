package org.project.service;

import org.project.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book getBook(int id);

    void addBook(Book book);

    void remove(Book book);

}
