package it.nntdata.corso.springjsp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;


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


    @ManyToMany(mappedBy = "skillses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Projects> projectses = new LinkedHashSet<>();

}
