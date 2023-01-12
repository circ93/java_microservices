package it.course.course_spring.business.impl;

import it.course.course_spring.business.ExamBO;
import it.course.course_spring.model.Exam;
import it.course.course_spring.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExamBoImpl implements ExamBO {

    @Autowired
    ExamRepository examRepository;

    @Override
    public Exam save(Exam exam) {
        examRepository.save(exam);
        return exam;
    }

    @Override
    public Set<Exam> findAllExams() {
        return (Set<Exam>) examRepository.findAll();
    }

    @Override
    public Exam findExamByID(long id) {
        return examRepository.getReferenceById(id);
    }

    @Override
    public void deleteRoleByID(long id) {
        examRepository.deleteById(id);
    }

    @Override
    public Set<Exam> findExamByEvalutation(int vote) {
        return examRepository.getExamByEvalutation(vote);
    }
}
