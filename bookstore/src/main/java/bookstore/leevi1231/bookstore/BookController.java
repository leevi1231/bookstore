package bookstore.leevi1231.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }
}
