package org.example.bookManager.service;

import org.example.bookManager.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void addBook(Book book);

    List<Book> getAllBooks();

    Optional<Book> getBookDetail(Integer bookId);

    void updateBookInfo(Book book);

    void deleteBook(Integer bookId);
}
