package it.nntdata.corso.springjsp.repository;

import it.nntdata.corso.springjsp.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {
}
