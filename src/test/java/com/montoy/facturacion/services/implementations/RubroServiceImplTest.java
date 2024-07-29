package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.Factories.RubroFactory;
import com.montoy.facturacion.exceptions.ReachLevelLimitException;
import com.montoy.facturacion.model.Rubro;
import com.montoy.facturacion.repositories.RubroRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RubroServiceImplTest {



    @Autowired
    private RubroRepository rubroRepository;


    private RubroServiceImpl rubroService;


    @BeforeEach
    void setUp() {
        rubroService = new RubroServiceImpl(rubroRepository);
    }

    @AfterEach
    void tearDown() {
    }



    @Test
    void retrieveRubros() {
        List<Rubro> listatest = rubroService.retrieveRubros();
        Assertions.assertEquals(94,listatest.size());
    }

    @Test
    void retrieveByID() {
        Rubro test = rubroService.retrieveByID(9L);
        Assertions.assertEquals(9L,test.getIdRubro());
    }

    @Test
    void retrieve50perPage() {
        Page<Rubro> paginatest = rubroService.retrieve50perPage(1);
        Assertions.assertEquals(50,paginatest.getNumberOfElements());
    }

    @Test
    void retrieve25perPage() {
        Page<Rubro> paginatest = rubroService.retrieve25perPage(2);
        Assertions.assertEquals(25,paginatest.getNumberOfElements());
    }

    @Test
    void retrieve10perPage() {
        Page<Rubro> paginatest = rubroService.retrieve10perPage(2);
        Assertions.assertEquals(10,paginatest.getNumberOfElements());
    }

    @Test
    void addRubro() {
        try {
            Rubro addTest = null;
            addTest = RubroFactory.createRubro(null,"INDUMENTARIA","",null);
            rubroService.addRubro(addTest);
            Rubro compare = rubroService.retrieveRubros().getLast();
            Assertions.assertEquals(addTest.getNombreRubro(),compare.getNombreRubro());
        } catch (ReachLevelLimitException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateRubro()
    {
        try {
            Rubro modTest = rubroService.retrieveByID(20L);
            Rubro origin = RubroFactory.createRubro(modTest);
            modTest.setNombreRubro("LIBERTAD");
            rubroService.updateRubro(modTest);
            Rubro modTest2 = rubroService.retrieveByID(20L);
            Assertions.assertNotEquals(origin.getNombreRubro(),modTest2.getNombreRubro());
        } catch (Exception ex)
        {

        }
    }

    @Test
    void reachLevelLimitofRubrosTest()
    {
        try {
            Rubro N1 = RubroFactory.createRubro(1L,"Primero","",null);
            Rubro N2 = RubroFactory.createRubro(2L,"Segundo","",N1);
            Rubro N3 = RubroFactory.createRubro(3L,"Tercero","",N2);
            Rubro N4 = RubroFactory.createRubro(4L,"Cuarto","",N3);
            Rubro N5 = RubroFactory.createRubro(5L,"Quinto","",N4);
            Assertions.assertThrows(ReachLevelLimitException.class,() -> {
                Rubro N6 = RubroFactory.createRubro(6L,"Sexto","",N5);
            });
        } catch (ReachLevelLimitException e) {
            throw new RuntimeException(e);
        }
    }

}