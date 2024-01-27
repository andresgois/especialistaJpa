package org.example.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.StatusPagamantoEnum;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PagamentoBoleto {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private Integer pedidoId;

    private StatusPagamantoEnum statusPagamento;

    private String codigoBarras;
}
