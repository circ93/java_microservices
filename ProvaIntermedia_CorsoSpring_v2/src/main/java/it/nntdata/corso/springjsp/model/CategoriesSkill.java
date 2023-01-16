package it.nntdata.corso.springjsp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "categories_skill")
public class CategoriesSkill extends BaseEntity{

    private String name;
    private String description;

    @OneToMany(mappedBy = "cat")
    private List<Skills> skills;

}
