package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void display() {
        System.out.println("📘 BookRepository: Listing all books (Annotation Based)");
    }
}