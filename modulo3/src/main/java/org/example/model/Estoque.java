package org.example.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Estoque {

    @Id
    private Integer id;

    private Integer produtoId;

    private Integer quantidade;
}
