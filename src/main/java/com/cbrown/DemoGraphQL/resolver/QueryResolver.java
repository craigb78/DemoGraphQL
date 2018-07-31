package com.cbrown.DemoGraphQL.resolver;

import com.cbrown.DemoGraphQL.entity.Author;
import com.cbrown.DemoGraphQL.entity.Book;
import com.cbrown.DemoGraphQL.repository.AuthorRepository;
import com.cbrown.DemoGraphQL.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;


/*
	findAllBooks: [Book]!
	countBooks: Long!


	findAllAuthors: [Author]!
	countAuthors: Long!
*/

	public Long countBooks(){
		return this.bookRepository.count();
	}

	public Iterable<Book> findAllBooks(){
		List<Book> all = this.bookRepository.findAll();
		return all;
	}

	public Iterable<Author> findAllAuthors(){
		List<Author> all = this.authorRepository.findAll();
		return all;
	}

	public Long countAuthors(){
		return this.authorRepository.count();
	}
}
