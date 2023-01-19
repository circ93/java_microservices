package it.nntdata.corso.springjsp.repository;

import it.nntdata.corso.springjsp.model.CategoriesSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriesSkillRepository extends JpaRepository<CategoriesSkill, Long> {

    @Query (value = "from CategoriesSkill c group by c.name")
    List<CategoriesSkill> getCategories();

}