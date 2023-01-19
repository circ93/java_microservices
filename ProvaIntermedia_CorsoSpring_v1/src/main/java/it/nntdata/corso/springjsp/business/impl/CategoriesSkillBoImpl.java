package it.nntdata.corso.springjsp.business.impl;

import it.nntdata.corso.springjsp.business.interfaces.CategoriesSkillBO;
import it.nntdata.corso.springjsp.model.CategoriesSkill;
import it.nntdata.corso.springjsp.repository.CategoriesSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesSkillBoImpl implements CategoriesSkillBO {

    @Autowired
    CategoriesSkillRepository categoriesSkillRepository;

    @Override
    public List<CategoriesSkill> findAll() throws DataAccessException {
        return categoriesSkillRepository.findAll();
    }

    @Override
    public List<CategoriesSkill> getCategories() throws DataAccessException {
        return categoriesSkillRepository.getCategories();
    }

    @Override
    public void save(CategoriesSkill category) throws DataAccessException {
        categoriesSkillRepository.save(category);
    }

    @Override
    public String createCategory(CategoriesSkill category) throws DataAccessException {
        String msg = null;

        if (category == null) {
            msg = "I dati ineriti non sono validi";
        } else {
            categoriesSkillRepository.save(category);
            msg = "Categoria inserita correttamente!";
        }

        return msg;
    }

    @Override
    public String deleteCategory(Long id) throws DataAccessException {

        CategoriesSkill _cat = categoriesSkillRepository.getReferenceById(id);

        String msg = null;

        if (_cat == null){
            msg = "Id non trovato";
        } else {
            categoriesSkillRepository.deleteById(id);
            msg = "Categoria eliminata!";
        }
        return msg;
    }

    @Override
    public CategoriesSkill searchCategoryById(Long id) throws DataAccessException {
        CategoriesSkill _cat = categoriesSkillRepository.getReferenceById(id);

        if (_cat == null){
            return null;
        } else {
            return _cat;
        }
    }
}
