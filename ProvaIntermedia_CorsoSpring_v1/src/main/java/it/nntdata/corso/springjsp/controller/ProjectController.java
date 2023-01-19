package it.nntdata.corso.springjsp.controller;

import it.nntdata.corso.springjsp.business.interfaces.ProjectBO;
import it.nntdata.corso.springjsp.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectBO projectBO;

    @GetMapping(path = {"/projects"})
    public ModelAndView getProjects() {
        List<Projects> listProject = projectBO.findAll();

        if (listProject.isEmpty()) {
            String msg = "Nessun progetto trovato!";
            return new ModelAndView("/jsp/projects.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/projects.jsp", "projects", listProject);
        }
    }

    @PostMapping(path = "/projects")
    public ModelAndView getProjects2(){
        List<Projects> listProject = projectBO.findAll();

        if (listProject.isEmpty()) {
            String msg = "Nessun progetto trovato!";
            return new ModelAndView("/jsp/projects.jsp", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/projects.jsp", "projects", listProject);
        }
    }

    @GetMapping(path = {"/newProject"})
    public ModelAndView newProject() {
        return new ModelAndView("/jsp/createProject.jsp");
    }

    @PostMapping(path = {"/createProject"})
    public ModelAndView createProject(@RequestParam String name, @RequestParam String description, @RequestParam String repo) {
        Projects _project = new Projects();

        _project.setName(name);
        _project.setDescription(description);
        _project.setRepo(repo);

        String msg = projectBO.createProject(_project);

        return new ModelAndView("/jsp/createProject.jsp", "msg_insert", msg);
    }

    @GetMapping(path = {"/deleteProject"})
    public ModelAndView deleteProject(@RequestParam Long id){

        String msg = projectBO.deleteProject(id);
        return new ModelAndView("/projects", "msg_delete", msg);
    }

    @GetMapping(path = {"/searchProject"})
    public ModelAndView searchProject(@RequestParam Long id) {
        Projects _project = projectBO.searchProjectById(id);

        String msg;
        if (_project == null){
            msg = "Project non trovato!";
            return new ModelAndView("/projects", "msg_error", msg);
        } else {
            return new ModelAndView("/jsp/editProject.jsp", "project", _project);
        }
    }

    @PostMapping(path = {"/updateProject"})
    public ModelAndView updateProject(@RequestParam Long id, String name, String description, String repo) {

        Projects _project = projectBO.searchProjectById(id);
        String msg;

        if (_project == null) {
            msg = "Non è stato possibile eliminare l'id selezionato.";
        } else {
            _project.setName(name);
            _project.setDescription(description);
            _project.setRepo(repo);

            projectBO.save(_project);
            msg = "Project aggiornato correttamente!";
        }

        return new ModelAndView("/projects", "msg_update", msg);
    }

}
