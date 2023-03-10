package org.project;

import org.project.controller.BookController;
import org.project.controller.OrderController;
import org.project.model.Book;
import org.project.model.User;
import org.project.repository.BookRepository;
import org.project.repository.BookRepositoryImpl;
import org.project.repository.HomeRepository;
import org.project.repository.HomeRepositoryImpl;
import org.project.service.BookService;
import org.project.service.BookServiceImpl;
import org.project.service.OrderService;
import org.project.service.OrderServiceImpl;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {


        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookServiceImpl(bookRepository);
        BookController bookController = new BookController(bookService);

        HomeRepository homeRepository = new HomeRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(homeRepository);
        OrderController orderController = new OrderController(orderService);

        List<Book> bookList = bookController.getAll();
        bookList.forEach(System.out::println);
        System.out.println("Input book id which you want take : ");

        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        Book book = bookController.getBook(id);
        bookController.deleteBookFromLibrary(book);
        User user = new User(1, "Alex");
        System.out.println("User " + user.getName() + " took book : ");
        orderController.putBookToUserHome(user, book);
        List<Book> books = orderController.getAll(user);
        books.forEach(System.out::println);
        System.out.println("\nList book in library after " + user.getName() + " choice :");
        bookList.forEach(System.out::println);
        System.out.println();


        System.out.println("Enter book id for return to library:");
        Book bookByUser = orderController.putBookToUserHome(user, book);
        sc = new Scanner(System.in);
        int i = sc.nextInt();
        while (i != bookByUser.getId()) {
            System.out.println("Your input not is correct,please enter book id by Alex : ");
            i = sc.nextInt();
        }
        boolean removeBookFromUser = orderController.removeBookFromUser(bookByUser.getId(), user);
        if (removeBookFromUser) {
            books.remove(bookByUser);
            System.out.println("Books by " + user.getName() + " after return book : " + books.size());
            bookList.add(bookByUser);
            System.out.println("\nFull books list in library : ");
            bookList.forEach(System.out::println);
        }
        sc.close();
    }
}