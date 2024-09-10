package com.example.demo.bookManagement.controller;

import com.example.demo.bookManagement.dto.response.BookDto;
import com.example.demo.bookManagement.service.BookManagementService;
import com.example.demo.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookManagementService service;

    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam Long id) {
        service.deleteBook(id);
    }

    @PostMapping("/save")
    public ApiResponse save(@RequestBody BookDto dto) {
        return service.addBook(dto);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestParam Long id, @RequestBody BookDto bookDto) {
        return service.updateBook(id, bookDto);
    }

    @GetMapping("/")
    public List<BookDto> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/id")
    public BookDto getById(@RequestParam Long id) {
        return service.getBookById(id);
    }

    @GetMapping("/byCategory")
    public List<BookDto> getBookByCategory(String category) {
        return service.getBooksByCategory(category);
    }

    @GetMapping("byAuthor")
    List<BookDto> getBooksByAuthor(@RequestParam String author){
    return service.getBooksByAuthor(author);}

    @GetMapping("byTitle")
    List<BookDto> searchBooksByTitle(@RequestParam String title){
        return service.searchBooksByTitle(title);
    }
}
