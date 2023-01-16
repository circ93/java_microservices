package it.nntdata.corso.springjsp.repository;

import it.nntdata.corso.springjsp.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillsRepository extends JpaRepository<Skills, Long> {

    @Query(value = "select distinct s.category from Skills s")
    List<String> getDistinctCategories();

}
