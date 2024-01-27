package org.example.model;


import lombok.Getter;
import lombok.Setter;
import org.example.enums.SexoEnum;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    private Integer id;

    private String nome;

    private SexoEnum sexo;
}
