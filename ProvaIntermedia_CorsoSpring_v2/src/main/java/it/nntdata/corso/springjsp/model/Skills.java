package it.nntdata.corso.springjsp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "skills")
public class Skills extends BaseEntity{

    private String name;
    private String description;
    private Long category;

    @ManyToOne
    @JoinColumn(
            name = "category",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private CategoriesSkill cat;


    //codice generato in automatico nella prova fatta con JPA BUDDY

    //@ManyToMany(mappedBy = "skillses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //private Set<Projects> projectses = new LinkedHashSet<>();

}
