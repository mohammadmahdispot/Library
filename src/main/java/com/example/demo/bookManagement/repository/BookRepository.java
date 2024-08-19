package com.example.demo.bookManagement.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategory(String category);
    List<Book> findByAuthor(String Author);
    List<Book> findByTitleContaining(String title);

}
