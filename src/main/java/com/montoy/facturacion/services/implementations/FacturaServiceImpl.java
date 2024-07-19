package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.Factura;
import com.montoy.facturacion.repositories.FacturaRepository;
import com.montoy.facturacion.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService
{
    @Autowired
    FacturaRepository facturaRepo;
    @Override
    public List<Factura> retrieveFacturas() {
        return facturaRepo.findAll();
    }

    @Override
    public Factura retrieveByID(Long ID) {
        return facturaRepo.findById(ID).orElse(null);
    }

    @Override
    public List<Factura> retrieveFacturasByCliente(Cliente cliente) {
        return null;
    }

    @Override
    public void insertarFactura(Factura factura) {
        facturaRepo.save(factura);
    }
}
