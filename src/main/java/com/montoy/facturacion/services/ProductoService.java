package com.montoy.facturacion.services;

import com.montoy.facturacion.model.Producto;
import com.montoy.facturacion.model.Rubro;

import java.util.List;


public interface ProductoService
{
    List<Producto> retrieveProductos();

    Producto retrieveByID(Long ID);

    Producto retrieveByBarCode(String barcode);

    List<Producto> retrieveByRubro(Long ID);

    void agregarProducto(Producto producto);

    void actualizarProducto(Producto producto);
}