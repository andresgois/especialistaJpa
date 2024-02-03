package org.example.relacionamento;

import org.example.enums.StatusPedidoEnum;
import org.example.factory.EntityManagerTest;
import org.example.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AutoRelacionamentoTest extends EntityManagerTest {

    @Test
    public void verificaCliente(){
        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletrônicos");

        Categoria categoria = new Categoria();
        categoria.setNome("Celulares");
        categoria.setCategoriaPai(categoriaPai);

        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Categoria categoriaVerificado = entityManager.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(categoriaVerificado.getCategoriaPai());

        Categoria categoriaPaiVerificado = entityManager.find(Categoria.class, categoriaPai.getId());
        Assert.assertFalse(categoriaPaiVerificado.getCategorias().isEmpty());
    }

}
