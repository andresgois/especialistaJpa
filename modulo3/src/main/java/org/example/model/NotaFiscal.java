package org.example.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_nota_fiscal")
public class NotaFiscal {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(name = "pedido_id")
    //private Integer pedidoId;
    @OneToOne
    //@JoinColumn(name = "pedido_id")
    @JoinTable(
            name = "pedido_nota_fiscal",
            joinColumns = @JoinColumn(name = "nota_fiscal_id", unique = true),
            inverseJoinColumns = @JoinColumn(name = "pedido_id", unique = true)
    )
    private Pedido pedido;

    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;
}
