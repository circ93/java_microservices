package it.nntdata.corso.springjsp.business.interfaces;

import it.nntdata.corso.springjsp.model.CategoriesSkill;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface CategoriesSkillBO {

    public List<CategoriesSkill> findAll() throws DataAccessException;

    public List<CategoriesSkill> getCategories() throws DataAccessException;

    public void save(CategoriesSkill category) throws DataAccessException;

    public String createCategory(CategoriesSkill category) throws DataAccessException;

    public String deleteCategory(Long id) throws DataAccessException;

    public CategoriesSkill searchCategoryById(Long id) throws DataAccessException;

}
