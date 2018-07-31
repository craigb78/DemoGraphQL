package com.cbrown.DemoGraphQL.repository;

import com.cbrown.DemoGraphQL.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
