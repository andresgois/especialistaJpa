package org.example.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Produto {


    @Id
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
