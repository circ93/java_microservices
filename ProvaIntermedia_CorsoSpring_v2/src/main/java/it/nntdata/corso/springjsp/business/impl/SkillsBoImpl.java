package it.nntdata.corso.springjsp.business.impl;

import it.nntdata.corso.springjsp.business.interfaces.SkillsBO;
import it.nntdata.corso.springjsp.model.Skills;
import it.nntdata.corso.springjsp.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsBoImpl implements SkillsBO {

    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public List<Skills> findAll() throws DataAccessException {
        return skillsRepository.findAll();
    }

    @Override
    public void save(Skills skill) throws DataAccessException {
        skillsRepository.save(skill);
    }

    @Override
    public String createSkill(Skills skill) throws DataAccessException {
        String msg = null;

        if (skill == null) {
            msg = "I dati ineriti non sono validi";
        } else {
            skillsRepository.save(skill);
            msg = "Skill inserita correttamente!";
        }

        return msg;
    }

    @Override
    public String deleteSkill(long id) throws DataAccessException {
        Skills _skill = skillsRepository.getReferenceById(id);

        String msg = null;

        if (_skill == null){
            msg = "Id non trovato";
        } else {
            skillsRepository.deleteById(id);
            msg = "Skill eliminata!";
        }
        return msg;
    }

    @Override
    public Skills searchSkillById(long id) throws DataAccessException {
        Skills _skill = skillsRepository.getReferenceById(id);

        if (_skill == null){
            return null;
        } else {
            return _skill;
        }
    }
}
