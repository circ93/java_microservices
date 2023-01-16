package it.nntdata.corso.springjsp.business.interfaces;

import it.nntdata.corso.springjsp.model.Projects;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProjectBO {

    public List<Projects> findAll() throws DataAccessException;

    public void save(Projects project) throws DataAccessException;

    public String createProject(Projects project) throws DataAccessException;

    public String deleteProject(Long id) throws DataAccessException;

}
