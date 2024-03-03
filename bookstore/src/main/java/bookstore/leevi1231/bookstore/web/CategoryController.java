package bookstore.leevi1231.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstore.leevi1231.bookstore.domain.Category;
import bookstore.leevi1231.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @RequestMapping(value = "/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }

    @RequestMapping(value = "/categories/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/categories/save")
    public String save(@ModelAttribute Category category, Model model) {
        repository.save(category);
        return "redirect:/categorylist";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId, Model model) {
        repository.deleteById(categoryId);
        return "redirect:/categorylist";
    }

}