package com.montoy.facturacion.services;


import com.montoy.facturacion.entitiesLists.ProveedorList;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.ProveedorPersFisica;
import com.montoy.facturacion.model.ProveedorPersJur;

import java.util.List;

public interface ProveedorService
{
    ProveedorList retrieveProveedores();

    Proveedor retrieveByID(Long ID);

    ProveedorPersFisica retrieveByDNI(Integer DNI);

    ProveedorPersJur retrieveByCuil(String Cuil);

    void agregarProveedor(Proveedor proveedor);

    void actualizarProveedor(Proveedor proveedor);
}