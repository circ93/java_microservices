package it.nntdata.corso.springjsp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "projects")
public class Projects extends BaseEntity{

    private String name;
    private String description;
    private String repo;


    //esempio fatto insieme per capire usando JPA BUDDY

    //@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinTable(name = "projects_skillses",
    //        joinColumns = @JoinColumn(name = "projects_id"),
    //        inverseJoinColumns = @JoinColumn(name = "skillses_id"))
    //private Set<Skills> skillses = new LinkedHashSet<>();


    //aggiungere add e remove del set
    //public void addSkill(Skills skill) {
    //    skillses.add(skill);
    //}

    //public void removeSkill(Skills skill ) {
    //    skillses.remove(skill);
    //}

}
