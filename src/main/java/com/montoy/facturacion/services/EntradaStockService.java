package com.montoy.facturacion.services;

import com.montoy.facturacion.model.EntradaStock;
import com.montoy.facturacion.model.Proveedor;

import java.util.List;

public interface EntradaStockService
{
    List<EntradaStock> retrieveEntradas();

    EntradaStock retrieveByID(Long ID);

    List<EntradaStock> retrieveEntradasByProveedor(Proveedor proveedor);

    void insertarEntradaStock(EntradaStock entrada);
}
