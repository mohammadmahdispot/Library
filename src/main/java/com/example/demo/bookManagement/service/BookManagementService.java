package com.example.demo.bookManagement.service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.payload.ApiResponse;

import java.util.List;

public interface BookManagementService {

    ApiResponse addBook(BookDto book);
    ApiResponse updateBook(Long id, BookDto bookDto);
    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
    ApiResponse deleteBook(Long id);
    List<BookDto> getBooksByCategory(String category);
    List<BookDto> getBooksByAuthor(String author);
    List<BookDto> searchBooksByTitle(String title);
}
