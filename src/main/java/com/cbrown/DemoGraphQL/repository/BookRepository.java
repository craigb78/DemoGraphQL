package com.cbrown.DemoGraphQL.repository;

import com.cbrown.DemoGraphQL.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
