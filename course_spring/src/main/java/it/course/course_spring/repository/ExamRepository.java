package it.course.course_spring.repository;

import it.course.course_spring.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    Exam getReferenceById(long id);

    Set<Exam> getExamByEvalutation(int vote);

}
