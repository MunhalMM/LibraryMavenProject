package org.project.repository;

import org.project.model.Book;
import org.project.model.User;

import java.util.List;

public interface HomeRepository {

    List<Book> getAll(User user);

    Book putBookToUserHome(User user, Book book);

    Book getBook(int bookId, User user);

    boolean removeBook(int bookId, User user);
}
