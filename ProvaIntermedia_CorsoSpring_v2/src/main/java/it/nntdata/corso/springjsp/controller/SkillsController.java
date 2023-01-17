package it.nntdata.corso.springjsp.controller;

import it.nntdata.corso.springjsp.business.interfaces.CategoriesSkillBO;
import it.nntdata.corso.springjsp.business.interfaces.SkillsBO;
import it.nntdata.corso.springjsp.model.CategoriesSkill;
import it.nntdata.corso.springjsp.model.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SkillsController {

    @Autowired
    SkillsBO skillsBO;

    @Autowired
    CategoriesSkillBO categoriesSkillBO;

    @GetMapping(path = {"/skills"})
    public ModelAndView getSkills(){
        List<Skills> listSkills = skillsBO.findAll();

        if (listSkills.isEmpty()) {
            String msg = "Non ci sono ancora skill!";
            return new ModelAndView("jsp/skills.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("jsp/skills.jsp", "skills", listSkills);
        }
    }

    @PostMapping(path = "/skills")
    public ModelAndView getSkills2(){
        List<Skills> listSkills = skillsBO.findAll();

        if (listSkills.isEmpty()) {
            String msg = "Non ci sono ancora skill!";
            return new ModelAndView("/jsp/skills.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/skills.jsp", "skills", listSkills);
        }
    }

    @GetMapping(path = {"/admin/newSkills"})
    public ModelAndView newSkills(){
        //recupero la lista di tutte le categori presenti così da popolare il dropdown menù
        List<CategoriesSkill> listCategories = categoriesSkillBO.getCategories();
        return new ModelAndView("/jsp/createSkills.jsp", "categories", listCategories);
    }

    @PostMapping(path = {"/admin/createSkills"})
    public ModelAndView createSkill(@RequestParam String name, @RequestParam String description, @RequestParam Long category) {
        Skills _skill = new Skills();
        _skill.setName(name);
        _skill.setDescription(description);
        _skill.setCategory(category);

        String msg = skillsBO.createSkill(_skill);

        return new ModelAndView("/jsp/createSkills.jsp", "msg_insert", msg);
    }

    @GetMapping(path = {"/admin/deleteSkill"})
    public ModelAndView deleteSkill(@RequestParam Long id){

        String msg = skillsBO.deleteSkill(id);
        return new ModelAndView("/skills", "msg_delete", msg);
    }

    @GetMapping(path = {"/admin/searchSkill"})
    public ModelAndView searchSkill(@RequestParam Long id) {
        Skills _skill = skillsBO.searchSkillById(id);

        String msg;
        if (_skill == null){
            msg = "Skill non trovata!";
            return new ModelAndView("/skills", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/editSkill.jsp", "skill", _skill);
        }
    }

    @PostMapping(path = {"/admin/updateSkill"})
    public ModelAndView updateSkill(@RequestParam Long id, String name, String description, Long category) {

        Skills _skill = skillsBO.searchSkillById(id);
        String msg;

        if (_skill == null) {
            msg = "Non è stato possibile eliminare l'id selezionato.";
        } else {
            _skill.setName(name);
            _skill.setDescription(description);
            _skill.setCategory(category);

            skillsBO.save(_skill);
            msg = "Skill aggiornata correttamente!";
        }

        return new ModelAndView("/skills", "msg_update", msg);
    }

}
