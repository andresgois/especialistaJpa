package org.example.mapeamento;

import org.example.enums.SexoEnum;
import org.example.factory.EntityManagerTest;
import org.example.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testarEnum(){
        Cliente cliente = new Cliente();
        //cliente.setId(4);
        cliente.setNome("Lucas martins");
        cliente.setSexo(SexoEnum.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Cliente cli = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(cli);
        Assert.assertEquals("Lucas martins", cli.getNome());
    }
}
