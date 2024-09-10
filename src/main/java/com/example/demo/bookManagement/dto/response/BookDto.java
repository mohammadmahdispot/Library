package com.example.demo.bookManagement.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    @NotNull(message = "title should not be null")
    private String title;
    @NotNull(message = "author should not be null")
    private String author;
    @NotNull(message = "category should not be null")
    private String category;
    @NotNull(message = "isbn should not be null")
    private Long isbn;


    public BookDto(String title, String author, String category, Long isbn) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
    }
}
