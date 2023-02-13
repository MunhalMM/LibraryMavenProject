package org.project.service;

import org.project.model.Book;
import org.project.model.User;

import java.util.List;

public interface OrderService {
    List<Book> allBooksByUser(User user);

    Book putBookToUserHome(User user, Book book);

    boolean removeBook(int bookId, User user);
}
