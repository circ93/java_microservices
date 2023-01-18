package it.nntdata.corso.springjsp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class CatSkill {

    private final String name;
    private final String description;

}
