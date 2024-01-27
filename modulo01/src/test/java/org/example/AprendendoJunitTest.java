package org.example;

import org.junit.*;

public class AprendendoJunitTest {

    @BeforeClass
    public static void init(){
        System.out.println("Inicio");
    }

    @AfterClass
    public static void finish(){
        System.out.println("Fim");
    }

    @Before
    public void initCadaTest(){
        System.out.println("initCadaTest");
    }

    @After
    public void finishCadaTest(){
        System.out.println("finishCadaTest");
    }

    @Test
    public void teste1(){
        System.out.println("Teste 1");
    }

    @Test
    public void teste2(){
        System.out.println("Teste 2");
    }
}
