package com.montoy.facturacion.services;

import com.montoy.facturacion.entitiesLists.ClienteList;
import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.ClientePersFisica;
import com.montoy.facturacion.model.ClientePersJur;

import java.util.List;

public interface ClienteService
{
    ClienteList retrieveClientes();

    Cliente retrieveByID(Long ID);

    ClientePersFisica retrieveByDNI(Integer DNI);

    ClientePersJur retrieveByCuil(String Cuil);

    void agregarCliente(Cliente cliente);

    void actualizarCliente(Cliente cliente);


}