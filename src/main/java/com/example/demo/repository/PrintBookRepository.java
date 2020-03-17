package com.example.demo.repository;

import com.example.demo.domain.PrintBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrintBookRepository extends JpaRepository<PrintBook, Long>, JpaSpecificationExecutor<PrintBook> {

}
