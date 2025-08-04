package ImplementingDependencyInjection;

import LibraryManagement.BookRepository;

public public class BookService {
    private BookRepository bookRepository;

    // Setter method for DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void display() {
        bookRepository.display();
    }
} {
    
}
