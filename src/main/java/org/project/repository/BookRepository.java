package org.project.repository;

import org.project.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();

    Book getBook(int id);

    void addBook(Book book);

    void removeBook(Book book);
}
