package it.corso.example.thymeleafproject.business.interfaces;

import it.corso.example.thymeleafproject.model.Category;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoryBO {
    Category getCategory(Long id);
    List<Category> getAllCategory();

    String save(Category cat) throws DataAccessException;
}
