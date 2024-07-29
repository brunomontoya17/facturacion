package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.Factories.AbstractClienteFactory;
import com.montoy.facturacion.Factories.ClientePersFisicaFactory;
import com.montoy.facturacion.Factories.ClientePersJurFactory;
import com.montoy.facturacion.entitiesLists.ClienteList;
import com.montoy.facturacion.exceptions.IncorrectClassCreatorException;
import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.ClientePersFisica;
import com.montoy.facturacion.model.ClientePersJur;
import com.montoy.facturacion.repositories.ClienteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ClienteServiceImplTest {

    @Autowired
    ClienteRepository clienteRepo;

    ClienteServiceImpl clienteService;

    AbstractClienteFactory CPFF = new ClientePersFisicaFactory();
    AbstractClienteFactory CPJF = new ClientePersJurFactory();

    @BeforeEach
    void setUp() {
        clienteService = new ClienteServiceImpl(clienteRepo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void retrieveClientes() {
        ClienteList listatest = clienteService.retrieveClientes();
        Assertions.assertNotEquals(0,listatest.size());
    }

    @Test
    void retrieveByID()
    {
        Cliente test = clienteService.retrieveByID(3L);
        Assertions.assertEquals(3L,test.getIdCliente());
    }

    @Test
    void agregarCliente()
    {
        Cliente addtest = null;
        try {
            addtest = CPFF.createCliente(null,"x@y.com","11xxxxyyyy"
                    ,"Ruiyt 777","Carlis","Jordez",12000000);
            clienteService.agregarCliente(addtest);
            Cliente compare = clienteService.retrieveClientes().getLast();
            Assertions.assertEquals(addtest.getNombreCompleto(),compare.getNombreCompleto());
        } catch (IncorrectClassCreatorException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void actualizarCliente()
    {
        Cliente modtest = null;
        modtest = clienteService.retrieveByID(4L);
        Cliente origin = null;
        if (modtest.getClass()== ClientePersFisica.class)
        {
            origin = CPFF.createCliente(modtest);
            ((ClientePersFisica) modtest).setApellido("Rubianes");
        }
        if (modtest.getClass() == ClientePersJur.class)
        {
            origin = CPJF.createCliente(modtest);
            ((ClientePersJur) modtest).setRazonSocial("JotaSuar S.A.");
        }
        modtest.setEmail("u@v.com");
        clienteService.actualizarCliente(modtest);
        Cliente modtest2 = clienteService.retrieveByID(4L);
        Assertions.assertNotEquals(origin.getNombreCompleto(),modtest2.getNombreCompleto());
        Assertions.assertNotEquals(origin.getEmail(),modtest2.getEmail());
    }
}