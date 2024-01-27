package org.example.model;


import lombok.Getter;
import lombok.Setter;
import org.example.enums.SexoEnum;
import org.example.enums.StatusPedidoEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    private Integer id;

    private LocalDateTime dataPedido;

    private LocalDateTime dataConclusao;

    private Integer notaFiscalId;

    private BigDecimal total;

    private StatusPedidoEnum status;

}
