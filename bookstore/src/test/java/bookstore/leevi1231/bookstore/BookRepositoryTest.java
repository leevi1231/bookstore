package bookstore.leevi1231.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bookstore.leevi1231.bookstore.domain.Book;
import bookstore.leevi1231.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {
    
    @Autowired
    private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Book> books = repository.findByTitle("To Kill a Mockingbird");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Harper Lee");
    }

    @Test
    public void createNewStudent() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0061120084", 9.99, null);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }
}