package org.example.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.StatusPagamantoEnum;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_pagamento_cartao")
public class PagamentoCartao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(name = "pedido_id")
    //private Integer pedidoId;
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Column(name = "status_pagamento")
    @Enumerated(EnumType.STRING)
    private StatusPagamantoEnum statusPagamento;

    private String numero;
}
