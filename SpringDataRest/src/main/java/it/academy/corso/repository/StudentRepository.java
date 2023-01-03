package it.academy.corso.repository;

import it.academy.corso.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//per identificare la tabella nel DB utilizzo il tipo di dato Student e il tipo di chiave primaria Long
//è qui che avviene il mapping con il DB tramite Hibernate
public interface StudentRepository extends JpaRepository<Student, Long> {
}