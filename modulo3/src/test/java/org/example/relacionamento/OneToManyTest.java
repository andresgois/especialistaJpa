package org.example.relacionamento;

import org.example.enums.StatusPedidoEnum;
import org.example.factory.EntityManagerTest;
import org.example.model.Cliente;
import org.example.model.ItemPedido;
import org.example.model.Pedido;
import org.example.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OneToManyTest extends EntityManagerTest {

    @Test
    public void verificaCliente(){
        Cliente cli = entityManager.find(Cliente.class, 1);

        Pedido p =  new Pedido();
        p.setStatus(StatusPedidoEnum.PAGO);
        p.setDataPedido(LocalDateTime.now());
        p.setTotal(BigDecimal.TEN);
        p.setCliente(cli);

        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente cliVerificado = entityManager.find(Cliente.class, cli.getId());
        Assert.assertFalse(cliVerificado.getPedidos().isEmpty());
    }

    @Test
    public void verificaClienteItemPedido(){
        Cliente cli = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido p =  new Pedido();
        p.setStatus(StatusPedidoEnum.PAGO);
        p.setDataPedido(LocalDateTime.now());
        p.setTotal(BigDecimal.TEN);
        p.setCliente(cli);

        ItemPedido ip =  new ItemPedido();
        ip.setQuantidade(1);
        ip.setPedido(p);
        ip.setProduto(produto);
        ip.setPrecoProduto(BigDecimal.ONE);

        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.persist(ip);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificado = entityManager.find(Pedido.class, p.getId());
        Assert.assertFalse(pedidoVerificado.getItens().isEmpty());
    }

}
