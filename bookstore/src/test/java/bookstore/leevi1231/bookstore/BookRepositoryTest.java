package bookstore.leevi1231.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bookstore.leevi1231.bookstore.domain.Book;
import bookstore.leevi1231.bookstore.domain.BookRepository;
import bookstore.leevi1231.bookstore.domain.Category;
import bookstore.leevi1231.bookstore.domain.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository repository2;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("To Kill a Mockingbird");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Harper Lee");
    }

    @Test
    public void createNewBook() {
        Category category = new Category("Scifi");
    	repository2.save(category);
        Book book = new Book("1984", "George Orwell", 1960, "978-0061120084", 9.99, category);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        List<Book> books = repository.findByTitle("To Kill a Mockingbird");
        Book book = books.get(0);
        repository.delete(book);
        List<Book> newBooks = repository.findByTitle("To Kill a Mockingbird");
        assertThat(newBooks).hasSize(0);
    }
}