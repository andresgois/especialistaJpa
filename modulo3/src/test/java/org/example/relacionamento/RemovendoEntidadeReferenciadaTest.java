package org.example.relacionamento;

import org.example.factory.EntityManagerTest;
import org.example.model.Categoria;
import org.example.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

public class RemovendoEntidadeReferenciadaTest extends EntityManagerTest {

    @Test
    public void removerEntidadeRelacionada(){

        Pedido pedido = entityManager.find(Pedido.class, 1);

        Assert.assertFalse(pedido.getItens().isEmpty());

        entityManager.getTransaction().begin();
        // duas forma de deletar itens referenciados, um em cascata e a outra é essa abaixo
        pedido.getItens().forEach(i-> entityManager.remove(i));
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido p = entityManager.find(Pedido.class, 1);
        Assert.assertNull(p);
    }

}
