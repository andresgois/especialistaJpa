package org.example.relacionamento;

import org.example.enums.SexoEnum;
import org.example.enums.StatusPagamantoEnum;
import org.example.enums.StatusPedidoEnum;
import org.example.factory.EntityManagerTest;
import org.example.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Test
    public void testeLazy(){
        Produto produto = new Produto();
        produto.setCategorias(null);
        produto.setNome("Cafe");
        produto.setDescricao("Café");
        produto.setPreco(new BigDecimal("7.59"));

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(5);
        itemPedido.setPrecoProduto(new BigDecimal("7.59"));
        itemPedido.setProduto(produto);

        Cliente cliente = new Cliente();
        cliente.setSexo(SexoEnum.MASCULINO);
        cliente.setNome("Andreia");
        //cliente.setPedidos();
        List<ItemPedido> ip = new ArrayList<>();
        ip.add(itemPedido);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedidoEnum.PAGO);
        pedido.setItens(ip);

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.persist(cliente);
        entityManager.persist(itemPedido);
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertTrue(pedidoVerificado.getItens().isEmpty());
        Assert.assertNotNull(pedidoVerificado);
    }

    @Test
    public void pedidoBanco(){
        Pedido p = entityManager.find(Pedido.class, 1);
        System.out.println("AQUI");
    }
}
