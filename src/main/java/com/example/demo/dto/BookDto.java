package com.example.demo.dto;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class BookDto {

    private String title;

    private String author;

    private String category;

    private Long isbn;

    public BookDto() {
    }

    public BookDto( String title, String author, String category, Long isbn) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
    }
}
