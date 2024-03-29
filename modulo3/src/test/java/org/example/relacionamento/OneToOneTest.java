package org.example.relacionamento;

import org.example.enums.StatusPagamantoEnum;
import org.example.enums.StatusPedidoEnum;
import org.example.factory.EntityManagerTest;
import org.example.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class OneToOneTest extends EntityManagerTest {

    @Test
    public void verificaCliente(){
        Pedido p = entityManager.find(Pedido.class, 1);

        PagamentoCartao pg = new PagamentoCartao();
        pg.setNumero("1234");
        pg.setStatusPagamento(StatusPagamantoEnum.PROCESSANDO);
        pg.setPedido(p);

        entityManager.getTransaction().begin();
        entityManager.persist(pg);
        entityManager.getTransaction().commit();
        entityManager.clear();

        PagamentoCartao pedidoPagamentoVerificado = entityManager.find(PagamentoCartao.class, pg.getId());
        Assert.assertNotNull(pedidoPagamentoVerificado);
    }

    @Test
    public void verificaNotaFiscal(){
        Pedido p = entityManager.find(Pedido.class, 1);

        NotaFiscal nf = new NotaFiscal();
        nf.setXml("<xml>");
        nf.setDataEmissao(new Date());
        nf.setPedido(p);

        entityManager.getTransaction().begin();
        entityManager.persist(nf);
        entityManager.getTransaction().commit();
        entityManager.clear();

        NotaFiscal notaFiscalVerificado = entityManager.find(NotaFiscal.class, nf.getId());
        Assert.assertNotNull(notaFiscalVerificado);
    }
}
