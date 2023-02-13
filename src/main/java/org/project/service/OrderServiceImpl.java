package org.project.service;

import org.project.model.Book;
import org.project.model.User;
import org.project.repository.HomeRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private HomeRepository homeRepository;


    public OrderServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public List<Book> allBooksByUser(User user) {
        return homeRepository.getAll(user);
    }

    @Override
    public Book putBookToUserHome(User user, Book book) {
        return homeRepository.putBookToUserHome(user, book);
    }

    @Override
    public boolean removeBook(int bookId, User user) {
        return homeRepository.removeBook(bookId, user);
    }
}
