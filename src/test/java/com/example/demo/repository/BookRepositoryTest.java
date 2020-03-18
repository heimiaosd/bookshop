package com.example.demo.repository;

import com.example.demo.BaseTest;
import com.example.demo.domain.Book;
import com.example.demo.domain.EBook;
import com.example.demo.domain.PrintBook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.criteria.*;
import java.util.List;


public class BookRepositoryTest extends BaseTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PrintBookRepository printBookRepository;
    private PlatformTransactionManager transactionManager;

    @Test
    public void test1(){
        Pageable pageable = PageRequest.of(0,10, Sort.by(Direction.DESC,"name"));

        Book book = new Book();
        book.setName("战争与和平");

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(book);
        Page<Book> books = bookRepository.findAll(example,pageable);

        Specification<Book> specification = new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p1 = criteriaBuilder.equal(root.get("name"),"战争与和平");
                Predicate p2 = criteriaBuilder.equal(root.get("category").get("name"),"世界名著");
                Predicate p3 = criteriaBuilder.and(p1,p2);

                root.fetch("category", JoinType.LEFT);
                return p3;
            }
        };
        bookRepository.findOne(specification);

        bookRepository.save(new Book());
    }

    @Test
    public void test2(){
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        Book book = bookRepository.findById(1L).get();
        book.setName("美女与野兽");
        bookRepository.save(book);

        transactionManager.commit(status);

    }

    @Test
    public void test3(){
        bookRepository.findAll();
        bookRepository.findAll();
    }

    @Test
    public void test4(){
        Book book = bookRepository.findById(1L).get();
        System.out.println(book.getCategory().getName());
    }

    @Test
    public void test5(){
        PrintBook printBook = new PrintBook();
        printBook.setName("霸道总裁爱上我");
        bookRepository.save(printBook);

        EBook eBook = new EBook();
        eBook.setName("校园风流少爷");
        bookRepository.save(eBook);

        List<Book> books = bookRepository.findAll();
        books.stream().forEach(book -> System.out.println(book.getClass().getSimpleName()));

        List<PrintBook> printBooks = printBookRepository.findAll();
        printBooks.stream().forEach(printBook1 -> System.out.println(printBook1.getClass().getSimpleName()) );
    }

    @Test
    public void test6(){
        PrintBook printBook = printBookRepository.findById(1000L).get();
        printBook.setName("狐妖在校园");
        printBookRepository.saveAndFlush(printBook);
    }

}
