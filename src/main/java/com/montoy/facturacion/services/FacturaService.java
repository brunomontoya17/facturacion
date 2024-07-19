package com.montoy.facturacion.services;

import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.Factura;

import java.util.List;

public interface FacturaService
{
    public List<Factura> retrieveFacturas();

    public Factura retrieveByID(Long ID);

    public List<Factura> retrieveFacturasByCliente(Cliente cliente);

    public void insertarFactura(Factura factura);
}
