package bookstore.leevi1231.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.leevi1231.bookstore.domain.Book;
import bookstore.leevi1231.bookstore.domain.BookRepository;
import bookstore.leevi1231.bookstore.domain.Category;
import bookstore.leevi1231.bookstore.domain.CategoryRepository;
import bookstore.leevi1231.bookstore.domain.User;
import bookstore.leevi1231.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository repository2, UserRepository repository3) {
		return (args) -> {
			
			Category category1 = new Category("Scifi");
			repository2.save(category1);
			Category category2 = new Category("Fantasy");
			repository2.save(category2);
			Category category3 = new Category("Comedy");
			repository2.save(category3);

			repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "978-0743273565", 12.99, category1));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0061120084", 9.99, category2));

			log.info("fetch all books");

			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			User user1 = new User("user",
			"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin",
			"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			repository3.save(user1);
			repository3.save(user2);

			log.info(user1.toString());
			log.info(user2.toString());

		};
	}
}