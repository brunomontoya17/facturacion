package com.montoy.facturacion.services;

import com.montoy.facturacion.model.CodigoProdProv;
import com.montoy.facturacion.model.Producto;
import com.montoy.facturacion.model.Rubro;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductoService
{
    List<Producto> retrieveProductos();

    Producto retrieveByID(Long ID);

    Producto retrieveByBarCode(String barcode);

    Page<Producto> retrieve100perPage(Integer page);

    Page<Producto> retrieve50perPage(Integer page);

    Page<Producto> retrieve25perPage(Integer page);

    List<Producto> retrieveByRubro(Long ID);

    CodigoProdProv retrieveByProdAndProv(Long prod,Long prov);

    void agregarCodigosProveedor(List<CodigoProdProv> codigos);

    void agregarProducto(Producto producto);

    void actualizarProducto(Long ID, Producto producto);
}
