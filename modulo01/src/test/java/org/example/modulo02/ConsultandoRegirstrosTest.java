package org.example.modulo02;

import org.example.factory.EntityManagerTest;
import org.example.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegirstrosTest extends EntityManagerTest {

    @Test
    public void buscarPorIdentificador(){
        Produto produto = entityManager.find(Produto.class, 1);
        //Produto produto = entityManager.getReference(Produto.class, 1);
        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizarAReferencia(){
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Microfone");
        // volta estado do banco
        entityManager.refresh(produto);

        Assert.assertEquals("Kindle", produto.getNome());
    }
}
