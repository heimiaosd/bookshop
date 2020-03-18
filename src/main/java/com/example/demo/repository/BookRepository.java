package com.example.demo.repository;

import com.example.demo.domain.Book;
import com.example.demo.support.BookShopRepository;
import org.springframework.data.jpa.repository.EntityGraph;

public interface BookRepository extends BookShopRepository<Book> {
   /* @Query("from Book b left join b.category where  b.name = ?1")
    Book findByName(String name);*/

   @EntityGraph("Book.fetch.category.and.author")
    Book findByName(String bookName);
}
