package org.example.bookmanager.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmanager.entity.Book;
import org.example.bookmanager.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookDetail(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public void updateBookInfo(Book book) {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
