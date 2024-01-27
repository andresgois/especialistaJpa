package org.example.modulo02;

import org.example.factory.EntityManagerTest;
import org.example.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTrasacaoTest extends EntityManagerTest {

    //@Test
    public void abrirEFecharTransacao(){
        Produto produto =  new Produto();

        entityManager.getTransaction().begin();

        entityManager.persist(produto);
        entityManager.merge(produto);
        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }


    @Test
    public void inserirPrimeiroObjeto(){
        Produto produto =  new Produto();

        produto.setId(2);
        produto.setNome("Camera");
        produto.setDescricao("A melhor definicção");
        produto.setPreco(new BigDecimal(59.98));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        /**
         * Manda o que estive na memória do entity manager para o bando
         * imediatamente, se não existir trasanção aberta dará erro.
         *
         * entityManager.getTransaction().commit(); -> já faz um flush por
         * de baixo dos panos
         */
        //entityManager.flush();
        entityManager.getTransaction().commit();
        // limpa a mnemoria do entity manager
        entityManager.clear();

        Produto p =  entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(p);
    }

    @Test
    public void removerobjeto(){
        Produto p =  entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao =  entityManager.find(Produto.class, 3);

        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjeto(){
        Produto p =  new Produto();

        p.setId(1);
        p.setNome("Kindle book");
        p.setPreco(new BigDecimal(89.95));
        p.setDescricao("New Kindle");

        entityManager.getTransaction().begin();
        entityManager.merge(p);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto pUpdate =  entityManager.find(Produto.class, 1);
        Assert.assertEquals("Kindle book", pUpdate.getNome());
    }

    @Test
    public void atualizarObjetoGerenciado(){
        Produto p =  entityManager.find(Produto.class, 1);

        p.setNome("Kindle book");
        p.setPreco(new BigDecimal(89.95));

        entityManager.getTransaction().begin();
        entityManager.merge(p);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto pUpdate =  entityManager.find(Produto.class, 1);
        Assert.assertEquals("Kindle book", pUpdate.getNome());
    }

    @Test
    public void inserirObjetoComMerge(){
        Produto p =  new Produto();

        p.setId(5);
        p.setNome("Kindle book");
        p.setPreco(new BigDecimal(89.95));
        p.setDescricao("New Kindle");

        entityManager.getTransaction().begin();
        entityManager.merge(p);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto pUpdate =  entityManager.find(Produto.class, 5);
        Assert.assertEquals("Kindle book", pUpdate.getNome());
    }
}
