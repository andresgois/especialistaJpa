package org.example.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_produto")
public class Produto {


    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
