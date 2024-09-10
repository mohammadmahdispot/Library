package com.example.demo.bookManagement.service.impl;

import com.example.demo.bookManagement.repository.BookRepository;
import com.example.demo.bookManagement.service.BookManagementService;
import com.example.demo.bookManagement.dto.response.BookDto;
import com.example.demo.bookManagement.entity.Book;
import com.example.demo.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookManagementServiceImpl implements BookManagementService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ApiResponse addBook(BookDto book) {
        Book addBook = new Book();
        addBook.setTitle(book.getTitle());
        addBook.setAuthor(book.getAuthor());
        addBook.setCategory(book.getCategory());
        addBook.setIsbn(book.getIsbn());

        bookRepository.save(addBook);
        return new ApiResponse(true, "operation successfully done");
    }

    @Override
    public ApiResponse updateBook(Long id, BookDto bookDto) {
        Optional<Book> bookOpt = bookRepository.findById(id);

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setCategory(bookDto.getCategory());
            book.setIsbn(bookDto.getIsbn());

            bookRepository.save(book);
            return new ApiResponse(true, "operation successfully done");
        } else
            return new ApiResponse(false, "error!!");
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAllBooksDto();
    }

    @Override
    public BookDto getBookById(Long bookId) {
        return bookRepository.findBookById(bookId);

    }

    public ApiResponse deleteBook(Long id) {
        if (id == null){
            return new ApiResponse(false, "Book not found.",404);}else {
            bookRepository.deleteById(id);
//        if (bookRepository.existsById(id)) {
//            bookRepository.deleteById(id);
        }
            return new ApiResponse(true,"Book deleted successfully.",200);
    }

    @Override
    public List<BookDto> getBooksByCategory(String category) {
        List<Book> books = bookRepository.findByCategory(category);
        return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> searchBooksByTitle(String title) {
        List<Book> books = bookRepository.findByTitleContaining(title);
        return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BookDto convertToDTO(Book book) {
        return new BookDto(
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getIsbn()
        );
    }
}
