package it.nntdata.corso.springjsp.controller;

import it.nntdata.corso.springjsp.business.interfaces.SkillsBO;
import it.nntdata.corso.springjsp.model.Skills;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SkillsController {

    @Autowired
    SkillsBO skillsBO;

    @GetMapping(path = {"/", "/index"})
    public ModelAndView getCategory(){
        //List<Skills> listCategory = skillsBO.findAll();
        List<String> listCategories = skillsBO.findDistinctCategory();

        if (listCategories.isEmpty()) {
            String msg = "Non ci sono categorie!";
            return new ModelAndView("jsp/index.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("jsp/index.jsp", "categories", listCategories);
        }
    }

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
            return new ModelAndView("jsp/skills.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("jsp/skills.jsp", "skills", listSkills);
        }
    }

    @GetMapping(path = {"/newSkills"})
    public ModelAndView newSkills(){
        return new ModelAndView("jsp/createSkills.jsp");
    }

    @PostMapping(path = {"/createSkills"})
    public ModelAndView createSkill(@RequestParam String name, @RequestParam String description, @RequestParam String category) {
        Skills _skill = new Skills();
        _skill.setName(name);
        _skill.setDescription(description);
        _skill.setCategory(category);

        String msg = skillsBO.createSkill(_skill);

        return new ModelAndView("jsp/createSkills.jsp", "msg_insert", msg);
    }

    @GetMapping(path = {"/deleteSkill"})
    public ModelAndView deleteSkill(@RequestParam Long id){

        String msg = skillsBO.deleteSkill(id);
        return new ModelAndView("/skills", "msg_delete", msg);
    }

    @GetMapping(path = {"/searchSkill"})
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

    @PostMapping(path = {"/updateSkill"})
    public ModelAndView updateSkill(@RequestParam Long id, String name, String description, String category) {

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
