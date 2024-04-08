package org.example.bookmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @NotNull(message = "book name could not be null")
    private String bookName;

    @NotNull(message = "the author of the book could not be null")
    private String author;

    @Past
    private LocalDateTime publishedDate;

    public Book(String bookName, String author, LocalDateTime publishedDate) {
        this.bookName = bookName;
        this.author = author;
        this.publishedDate = publishedDate;
    }
}
