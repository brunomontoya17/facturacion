package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.Factories.AbstractProveedorFactory;
import com.montoy.facturacion.Factories.ProveedorPersFisicaFactory;
import com.montoy.facturacion.Factories.ProveedorPersJurFactory;
import com.montoy.facturacion.entitiesLists.ProveedorList;
import com.montoy.facturacion.exceptions.IncorrectClassCreatorException;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.ProveedorPersFisica;
import com.montoy.facturacion.model.ProveedorPersJur;
import com.montoy.facturacion.repositories.ProveedorRepository;
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
class ProveedorServiceImplTest {

    @Autowired
    ProveedorRepository proveedorRepo;

    ProveedorServiceImpl proveedorService;

    AbstractProveedorFactory PPFF = new ProveedorPersFisicaFactory();
    AbstractProveedorFactory PPJF = new ProveedorPersJurFactory();

    @BeforeEach
    void setUp() {
        proveedorService = new ProveedorServiceImpl(proveedorRepo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void retrieveProveedores()
    {
        ProveedorList listatest = proveedorService.retrieveProveedores();
        Assertions.assertNotEquals(0,listatest.size());
    }

    @Test
    void retrieveByID()
    {
        Proveedor test = proveedorService.retrieveByID(1L);
        Assertions.assertEquals(1L,test.getIdProveedor());
    }

    @Test
    void agregarProveedor()
    {
        Proveedor addTest = null;
        try {
            addTest = PPJF.createProveedor(null,"r@t.com","11hhhhmmmm",
                    "Hutu 1200","Kiur S.R.L.","99-oooopppp-6");
            proveedorService.agregarProveedor(addTest);
            Proveedor compare = proveedorService.retrieveProveedores().getLast();
            Assertions.assertEquals(addTest.getCuilDNI(),compare.getCuilDNI());
        } catch (IncorrectClassCreatorException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void actualizarProveedor()
    {
        Proveedor modTest1 = null;
        Proveedor modTest2 = null;
        modTest1 = proveedorService.retrieveByID(2L);
        modTest2 = proveedorService.retrieveByID(3L);
        Proveedor origin1 = null;
        Proveedor origin2 = null;
        if (modTest1.getClass()== ProveedorPersFisica.class){
            origin1 = PPFF.createProveedor(modTest1);
            ((ProveedorPersFisica) modTest1).setApellido("Rodriguez");
        }
        if (modTest1.getClass()== ProveedorPersJur.class) {
            origin1 = PPJF.createProveedor(modTest1);
            ((ProveedorPersJur) modTest1).setRazonSocial("Terty S.K.L.");
        }
        if (modTest2.getClass()== ProveedorPersFisica.class){
            origin2 = PPFF.createProveedor(modTest2);
            ((ProveedorPersFisica) modTest2).setDNI(99000999);
        }
        if (modTest2.getClass()== ProveedorPersJur.class) {
            origin2 = PPJF.createProveedor(modTest2);
            ((ProveedorPersJur) modTest2).setCuit_cuil("99-bbbbqqqq-1");
        }
        proveedorService.actualizarProveedor(modTest1);
        proveedorService.actualizarProveedor(modTest2);
        Proveedor finalTest1 = proveedorService.retrieveByID(2L);
        Proveedor finalTest2 = proveedorService.retrieveByID(3L);
        Assertions.assertNotEquals(origin1.getNombreCompleto(),finalTest1.getNombreCompleto());
        Assertions.assertNotEquals(origin2.getCuilDNI(),finalTest2.getCuilDNI());

    }

}