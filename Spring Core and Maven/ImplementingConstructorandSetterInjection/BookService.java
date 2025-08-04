package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private NotificationService notificationService;

    // Constructor injection
    public BookService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showBooks() {
        bookRepository.display();
        notificationService.notifyUser();
    }
}