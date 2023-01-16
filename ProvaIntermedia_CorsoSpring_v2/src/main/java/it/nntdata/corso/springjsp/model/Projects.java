package it.nntdata.corso.springjsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

}
