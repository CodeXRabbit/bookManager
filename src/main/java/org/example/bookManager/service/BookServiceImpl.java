package org.example.bookManager.service;

import lombok.RequiredArgsConstructor;
import org.example.bookManager.entity.Book;
import org.example.bookManager.repository.BookRepository;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Cacheable(value = "books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Cacheable(value = "book", key = "#bookId")
    public Optional<Book> getBookDetail(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    @CachePut(value = "book", key = "#book.bookId")
    public Book updateBookInfo(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteAllByIdInBatch(Collections.singletonList(bookId));
    }
}
