package org.example.bookManager.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.bookManager.entity.Book;
import org.example.bookManager.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<@NonNull String> addBook(@RequestBody @Valid Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Successfully add book");
    }

    @GetMapping("/getAll")
    public ResponseEntity<@NonNull List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/getOne/{bookId}")
    public ResponseEntity<@NonNull Book> getById(@PathVariable("bookId") @NotNull Integer bookId) {
        return ResponseEntity.of(bookService.getBookDetail(bookId));
    }

    @PutMapping("/update")
    public ResponseEntity<@NonNull String> updateBook(@RequestBody Book book) {
        Book resultBook = bookService.updateBookInfo(book);
        return ResponseEntity.ok(resultBook.toString());
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<@NonNull String> deleteBook(@PathVariable("bookId") Integer bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Successfully deleted book");
    }
}
