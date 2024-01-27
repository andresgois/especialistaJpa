package org.example.modulo02;

import org.example.factory.EntityManagerTest;
import org.example.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class ClientesCrudTest extends EntityManagerTest {

    @Test
    public void deveRetornaUmaEntidade(){
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assert.assertNotNull(cliente);
        Assert.assertEquals("André Gois", cliente.getNome());
    }

    @Test
    public void deveInserirUmCliente(){
        Cliente cliente = new Cliente();
        cliente.setId(4);
        cliente.setNome("Priscila Erica");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        Cliente c = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(c);
        Assert.assertEquals("Priscila Erica", c.getNome());
    }

    @Test
    public void deveAtualizarCliente(){
        Cliente c = entityManager.find(Cliente.class, 1);

        c.setNome("Francisco Andre Gois");
        entityManager.getTransaction().begin();
        entityManager.merge(c);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Cliente clienteUpdate = entityManager.find(Cliente.class, c.getId());
        System.out.println(">>>> "+clienteUpdate.getNome());
        Assert.assertNotNull(c);
        Assert.assertEquals("Francisco Andre Gois", clienteUpdate.getNome());
    }

    @Test
    public void deveRemoverUmCliente(){
        Cliente c = entityManager.find(Cliente.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(c);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteRemove = entityManager.find(Cliente.class, c.getId());
        Assert.assertNull(clienteRemove);
    }
}
