package com.cbrown.DemoGraphQL.resolver;

import com.cbrown.DemoGraphQL.entity.Author;
import com.cbrown.DemoGraphQL.entity.Book;
import com.cbrown.DemoGraphQL.repository.AuthorRepository;
import com.cbrown.DemoGraphQL.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MutationResolver implements GraphQLMutationResolver {

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;

	/*newAuthor(firstName: String!, lastName: String!): Author

	newBook(title: String!, isbn: String!, pageCount: Int, author: Author!): Book
	deleteBook(id: ID): Boolean
	updateBookPageCount(pageCount: Int!, id: ID!): Book*/


	public Author newAuthor(String firstName, String lastName){
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		return authorRepository.save(author);
	}

	public Book newBook(String title, String isbn, Integer pageCount, Long authorId){
		Author author = this.authorRepository.findById(authorId).orElseThrow(RuntimeException::new);

		Book book = new Book();
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setAuthor(author);
		book.setPageCount( pageCount !=  null ? pageCount: 0);
		return bookRepository.save(book);
	}

	public Boolean deleteBook(Long id){
		this.bookRepository.deleteById(id);
		return true;
	}

	public Book updateBookPageCount(int pageCount, Long id){
		Book b=  bookRepository.findById(id).get();
		b.setPageCount(pageCount);
		return bookRepository.save(b);
	}
}
