package it.nntdata.corso.springjsp.business.interfaces;

import it.nntdata.corso.springjsp.model.Skills;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface SkillsBO {

    public List<String> findDistinctCategory() throws DataAccessException;
    public List<Skills> findAll() throws DataAccessException;

    public String createSkill(Skills skill) throws DataAccessException;

    public void save(Skills skill) throws DataAccessException;

    public String deleteSkill(long id) throws DataAccessException;

    public Skills searchSkillById(long id) throws DataAccessException;

}
