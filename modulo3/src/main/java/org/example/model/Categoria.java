package org.example.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Categoria {

    @Id
    private Integer id;

    private String nome;

    private Integer categoriaPaiId;
}
