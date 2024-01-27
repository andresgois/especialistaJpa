package org.example.modulo02;

import org.example.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultandoRegirstrosTest {

    private static EntityManagerFactory entityManagerFactory;

    private static EntityManager entityManager;

    @BeforeClass
    public static void setBeforeClass(){
        entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterClass
    public static void setAfterClass(){
        entityManagerFactory.close();
    }

    @Before
    public void setUp(){
       entityManager  = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown(){
        entityManager.close();
    }

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
