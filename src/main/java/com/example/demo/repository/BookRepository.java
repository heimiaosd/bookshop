package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
   /* @Query("from Book b left join b.category where  b.name = ?1")
    Book findByName(String name);*/

   @EntityGraph("Book.fetch.category.and.author")
    Book findByName(String bookName);
}
