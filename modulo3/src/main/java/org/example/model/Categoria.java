package org.example.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_categoria")
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cat")
    @SequenceGenerator(name = "seq_cat", sequenceName = "seq_chave_primary_cat")*/

    /*@GeneratedValue(strategy = GenerationType.TABLE, generator = "tabela")
    @TableGenerator(name = "tabela", table = "hibernate_sequences",
                pkColumnName = "sequence_name", pkColumnValue = "categoria",
                valueColumnName = "next_val", initialValue = 0, allocationSize = 1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiId;
}
