package it.nntdata.corso.springjsp.controller;

import it.nntdata.corso.springjsp.business.interfaces.CategoriesSkillBO;
import it.nntdata.corso.springjsp.model.CategoriesSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoriesSkillController {

    @Autowired
    CategoriesSkillBO categoriesSkillBO;

    @GetMapping(path = {"/", "/index", "/home"})
    public ModelAndView getCategories() {
        List<CategoriesSkill> listCategories = categoriesSkillBO.getCategories();

        if (listCategories.isEmpty()) {
            String msg = "Non ci sono categorie!";
            return new ModelAndView("/jsp/index.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/index.jsp", "categories", listCategories);
        }
    }

    @GetMapping(path = {"/categories"})
    public ModelAndView getAllCategories() {
        List<CategoriesSkill> listCategories = categoriesSkillBO.findAll();

        if (listCategories.isEmpty()) {
            String msg = "Non ci sono categorie!";
            return new ModelAndView("/jsp/categoriesSkill.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/categoriesSkill.jsp", "categories", listCategories);
        }
    }

    @PostMapping(path = {"/categories"})
    public ModelAndView getAllCategories2() {
        List<CategoriesSkill> listCategories = categoriesSkillBO.findAll();

        if (listCategories.isEmpty()) {
            String msg = "Non ci sono categorie!";
            return new ModelAndView("/jsp/categoriesSkill.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/categoriesSkill.jsp", "categories", listCategories);
        }
    }

    @GetMapping(path = {"/deleteCategory"})
    public ModelAndView deleteCategory(@RequestParam Long id) {
        String msg = categoriesSkillBO.deleteCategory(id);

        return new ModelAndView("/categories", "msg_delete", msg);
    }

    @PostMapping(path = {"/createCategory"})
    public ModelAndView createCategory(@RequestParam String name, String description) {
        CategoriesSkill _cat = new CategoriesSkill();

        _cat.setName(name);
        _cat.setDescription(description);

        String msg = categoriesSkillBO.createCategory(_cat);

        return new ModelAndView("/categories", "msg_insert", msg);
    }

    @GetMapping(path = {"/searchCategory"})
    public ModelAndView searchCategory(@RequestParam Long id) {
        CategoriesSkill _cat = categoriesSkillBO.searchCategoryById(id);

        String msg;
        if (_cat == null){
            msg = "Categoria non trovata!";
            return new ModelAndView("/categories", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/editCategories.jsp", "category", _cat);
        }
    }

    @PostMapping(path = {"/updateCategory"})
    public ModelAndView updateCategory(@RequestParam Long id, String name, String description) {
        CategoriesSkill _cat = categoriesSkillBO.searchCategoryById(id);

        String msg;

        if (_cat == null) {
            msg = "Non è stato possibile eliminare l'id selezionato.";
        } else {
            _cat.setName(name);
            _cat.setDescription(description);

            categoriesSkillBO.save(_cat);
            msg = "Categoria aggiornata correttamente!";
        }

        return new ModelAndView("/categories", "msg_update", msg);
    }

}
