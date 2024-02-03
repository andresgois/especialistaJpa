package org.example.relacionamento;

import org.example.enums.StatusPedidoEnum;
import org.example.factory.EntityManagerTest;
import org.example.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ManyToManyTest extends EntityManagerTest {

    @Test
    public void verificaCliente(){
        Produto prod = entityManager.find(Produto.class, 1);
        Categoria cat = entityManager.find(Categoria.class, 2);

        entityManager.getTransaction().begin();
        //cat.setProdutos(Arrays.asList(prod));// não é o owner da relação
        prod.setCategorias(Arrays.asList(cat));
        entityManager.getTransaction().commit();
        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, cat.getId());
        Assert.assertFalse(categoriaVerificacao.getProdutos().isEmpty());
    }


}
