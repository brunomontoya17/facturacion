package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.entitiesLists.ClienteList;
import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.ClientePersFisica;
import com.montoy.facturacion.model.ClientePersJur;
import com.montoy.facturacion.repositories.ClienteRepository;
import com.montoy.facturacion.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepo;
    @Override
    public ClienteList retrieveClientes() {
        ClienteList clientes = new ClienteList();
        clientes.addAll(clienteRepo.findAll());
        return clientes;
    }

    @Override
    public Cliente retrieveByID(Long ID) {
        return clienteRepo.findById(ID).orElse(null);
    }

    @Override
    public ClientePersFisica retrieveByDNI(Integer DNI) {
        return null;
    }

    @Override
    public ClientePersJur retrieveByCuil(String Cuil) {
        return null;
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

}
