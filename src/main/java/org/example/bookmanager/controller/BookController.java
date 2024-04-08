package org.example.bookmanager.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmanager.entity.Book;
import org.example.bookmanager.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody @Valid Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Successfully add book");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/getOne/{bookId}")
    public ResponseEntity<Book> getById(@PathVariable("bookId") @NotNull Integer bookId) {
        return ResponseEntity.of(bookService.getBookDetail(bookId));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        bookService.updateBookInfo(book);
        return ResponseEntity.ok("Successfully update book");
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Successfully deleted book");
    }
}
