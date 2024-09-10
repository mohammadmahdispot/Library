package com.example.demo.bookManagement.repository;

import com.example.demo.bookManagement.dto.response.BookDto;
import com.example.demo.bookManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategory(String category);
    List<Book> findByAuthor(String Author);
    List<Book> findByTitleContaining(String title);
    @Query("select new com.example.demo.bookManagement.dto.response.BookDto(b.title,b.author,b.category,b.isbn) from Book b")
    List<BookDto> findAllBooksDto();
    @Query("select new com.example.demo.bookManagement.dto.response.BookDto(b.title,b.author,b.category,b.isbn) from Book b where b.id = :bookId")
    BookDto findBookById(Long bookId);


}
