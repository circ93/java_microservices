package it.nntdata.corso.springjsp.business.impl;

import it.nntdata.corso.springjsp.business.interfaces.ProjectBO;
import it.nntdata.corso.springjsp.model.Projects;
import it.nntdata.corso.springjsp.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectBoImpl implements ProjectBO {

    @Autowired
    ProjectsRepository projectsRepository;

    @Override
    public List<Projects> findAll() throws DataAccessException {
        return projectsRepository.findAll();
    }

    @Override
    public void save(Projects project) throws DataAccessException {
        projectsRepository.save(project);
    }

    @Override
    public String createProject(Projects project) throws DataAccessException {
        String msg = null;

        if (project == null) {
            msg = "I dati ineriti non sono validi";
        } else {
            projectsRepository.save(project);
            msg = "Project inserito correttamente!";
        }

        return msg;
    }

    @Override
    public String deleteProject(Long id) throws DataAccessException {
        Projects _progect = projectsRepository.getReferenceById(id);

        String msg = null;

        if (_progect == null){
            msg = "Id non trovato";
        } else {
            projectsRepository.deleteById(id);
            msg = "Project eliminato!";
        }
        return msg;
    }

    @Override
    public Projects searchProjectById(Long id) throws DataAccessException {
        Projects _project = projectsRepository.getReferenceById(id);

        if (_project == null){
            return null;
        } else {
            return _project;
        }
    }
}
