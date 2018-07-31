package com.cbrown.DemoGraphQL.resolver;

import com.cbrown.DemoGraphQL.entity.Author;
import com.cbrown.DemoGraphQL.entity.Book;
import com.cbrown.DemoGraphQL.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

	@Autowired
	private AuthorRepository authorRepository;

	public Author getAuthor(Book book){
		return authorRepository.findById(book.getAuthor().getId()).get();
	}
}
