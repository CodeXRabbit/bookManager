package org.example.bookManager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "book")
@JsonIgnoreProperties
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
