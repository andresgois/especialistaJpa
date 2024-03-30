package org.example.mapeamento;

import org.example.enums.SexoEnum;
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

        Cliente cliente = new Cliente();
        cliente.setSexo(SexoEnum.FEMININO);
        cliente.setNome("Andreia");

        Pedido pedido = new Pedido();
        //pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setDataConclusao(null);
        pedido.setStatus(StatusPedidoEnum.AGUARDADO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntrega(end);
        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Pedido p = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(p);
        Assert.assertEquals("Maranguape",p.getEnderecoEntrega().getCidade());
    }
}
