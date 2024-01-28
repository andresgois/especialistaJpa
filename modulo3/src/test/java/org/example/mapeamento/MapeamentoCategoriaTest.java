package org.example.mapeamento;

import org.example.enums.StatusPedidoEnum;
import org.example.factory.EntityManagerTest;
import org.example.model.Categoria;
import org.example.model.EnderecoEntregaPedido;
import org.example.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoCategoriaTest extends EntityManagerTest {

    @Test
    public void analisaMapeamentoObjetoEmbutido(){
        Categoria c = new Categoria();
        c.setNome("Eletrônicos");
        c.setCategoriaPaiId(1);

        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Categoria categoria = entityManager.find(Categoria.class, c.getId());
        Assert.assertNotNull(categoria);
        Assert.assertEquals("Eletrônicos",categoria.getNome());
    }
}
