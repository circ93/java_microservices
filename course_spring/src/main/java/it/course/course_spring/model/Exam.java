package it.course.course_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exams")
public class Exam {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column (name = "evalutation")
    private int evalutation;

    @NotBlank
    @Column
    private int giorno;

    @NotBlank
    @Column
    private int mese;

    @NotBlank
    @Column
    private int anno;


    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    @JoinTable(
            name = "course_exams",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )

    private Course course;



}
