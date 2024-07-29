package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.Factories.MarcaFactory;
import com.montoy.facturacion.model.Marca;
import com.montoy.facturacion.repositories.MarcaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MarcaServiceImplTest {

    @Autowired
    private MarcaRepository marcaRepository;

    private MarcaServiceImpl marcaService;

    @BeforeEach
    void setUp() {
        marcaService = new MarcaServiceImpl(marcaRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void retrieveMarcas() {
        List<Marca> listatest = marcaService.retrieveMarcas();
        Assertions.assertNotEquals(0L,listatest.size());
    }

    @Test
    void retrieveByID() {
        Marca test = marcaService.retrieveByID(4L);
        Assertions.assertEquals(4L,test.getIdMarca());
    }

    @Test
    void retrieve50perPage() {
        Page<Marca> paginatest = marcaService.retrieve50perPage(1);
        Assertions.assertEquals(50,paginatest.getNumberOfElements());
    }

    @Test
    void retrieve25perPage() {
        Page<Marca> paginatest = marcaService.retrieve25perPage(2);
        Assertions.assertEquals(25,paginatest.getNumberOfElements());
    }

    @Test
    void retrieve10perPage() {
        Page<Marca> paginatest = marcaService.retrieve10perPage(2);
        Page<Marca> lastPaginaTest = marcaService.retrieve10perPage(paginatest.getTotalPages());
        Assertions.assertTrue(lastPaginaTest.getNumberOfElements()<=10);
    }

    @Test
    void addMarca() {
        Marca addTest = MarcaFactory.createMarca(null,"COCA COLA","");
        marcaService.addMarca(addTest);
        Marca retrieveTest = marcaService.retrieveMarcas().getLast();
        Assertions.assertEquals(addTest.getNombreMarca(),retrieveTest.getNombreMarca());
    }

    @Test
    void updateMarca()
    {
        Marca modTest = marcaService.retrieveByID(5L);
        Marca origin = MarcaFactory.createMarca(modTest);
        System.out.println(origin.getNombreMarca());
        modTest.setNombreMarca("SPRITE");
        marcaService.updateMarca(modTest);
        Marca modTest2 = marcaService.retrieveByID(5L);
        System.out.println(modTest2.getNombreMarca());
        Assertions.assertNotEquals(origin.getNombreMarca(),modTest2.getNombreMarca());
    }
}