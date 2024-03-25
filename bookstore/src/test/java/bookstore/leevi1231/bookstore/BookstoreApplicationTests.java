package bookstore.leevi1231.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import bookstore.leevi1231.bookstore.web.BookController;
import bookstore.leevi1231.bookstore.web.CategoryController;

@SpringBootTest
public class BookstoreApplicationTests {

    @Autowired
    private BookController controller;

    @Autowired
    private CategoryController controller2;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(controller2).isNotNull();
    }
}