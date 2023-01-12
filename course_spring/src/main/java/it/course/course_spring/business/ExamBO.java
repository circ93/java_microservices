package it.course.course_spring.business;

import it.course.course_spring.model.Exam;

import java.util.Set;

public interface ExamBO {

    public Exam save(Exam exam);

    public Set<Exam> findAllExams();

    public Exam findExamByID(long id);

    public void deleteRoleByID(long id);

    public Set<Exam> findExamByEvalutation(int vore);

}
