package it.course.course_spring.controller;

import it.course.course_spring.business.ExamBO;
import it.course.course_spring.model.Exam;
import it.course.course_spring.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ExamController {

    @Autowired
    ExamBO examBO;

    @PostMapping("/setExam")
    public ResponseEntity<Exam> setExam(@RequestBody Exam exam){
        Exam _exam = examBO.save(exam);

        return new ResponseEntity<>(_exam, HttpStatus.CREATED);
    }

    @GetMapping("/getExams")
    public ResponseEntity<Set<Exam>> getExam(){
        Set<Exam> setExam = new HashSet<>();
        //examRepository.findAll().forEach(setExam::add);
        setExam = examBO.findAllExams();

        if (setExam.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(setExam, HttpStatus.OK);
        }
    }

    @PutMapping("/setExam/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable("id") long id, @RequestBody Exam examRequest){

        //Exam _exam = examRepository.getReferenceById(id);
        Exam _exam = examBO.findExamByID(id);

        if (_exam == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            _exam.setEvalutation(examRequest.getEvalutation());
            _exam.setAnno(examRequest.getAnno());
            _exam.setMese(examRequest.getMese());
            _exam.setGiorno(examRequest.getGiorno());

            Exam result = examBO.save(_exam);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @DeleteMapping("delExam/{id}")
    public ResponseEntity<?> deleteExam(@PathVariable("id") long id){
        //examRepository.deleteById(id);
        examBO.deleteRoleByID(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //restituisce tutti gli esami con la votazione passata
    @PostMapping("getExam/{vote}")
    public Set<Exam> getExamVote(@PathVariable("vote") int vote){

        //Set<Exam> setExam = examRepository.getExamByEvalutation(vote);
        Set<Exam> setExam = examBO.findExamByEvalutation(vote);

        return setExam;

    }
}
