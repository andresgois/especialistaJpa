package org.example.mapeamento;

import org.example.enums.StatusPedidoEnum;
import org.example.factory.EntityManagerTest;
import org.example.model.Cliente;
import org.example.model.EnderecoEntregaPedido;
import org.example.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

    @Test
    public void analisaMapeamentoObjetoEmbutido(){
        EnderecoEntregaPedido end = new EnderecoEntregaPedido();
        end.setCep("61942-000");
        end.setLogradouro("Rua 10");
        end.setNumero("123");
        end.setNumero("Centro");
        end.setCidade("Maranguape");
        end.setEstado("CE");

        Pedido pedido = new Pedido();
        //pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setDataConclusao(null);
        pedido.setStatus(StatusPedidoEnum.AGUARDADO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntrega(end);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Pedido p = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(p);
        Assert.assertEquals("Maranguape",p.getEnderecoEntrega().getCidade());
    }
}
