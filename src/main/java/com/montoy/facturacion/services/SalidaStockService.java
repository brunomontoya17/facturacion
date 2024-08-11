package com.montoy.facturacion.services;

import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.SalidaStock;

import java.util.List;

public interface SalidaStockService {
    List<SalidaStock> retrieveSalidas();

    SalidaStock retrieveByID(Long ID);

    List<SalidaStock> retrieveSalidasByProveedor(Proveedor proveedor);

    void insertarSalida(SalidaStock salidaStock);
}
