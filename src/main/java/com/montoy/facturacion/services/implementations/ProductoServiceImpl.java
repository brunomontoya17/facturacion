package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.Producto;
import com.montoy.facturacion.model.Rubro;
import com.montoy.facturacion.mybatismappers.ProductoXRubroMapper;
import com.montoy.facturacion.repositories.ProductoRepository;
import com.montoy.facturacion.repositories.RubroRepository;
import com.montoy.facturacion.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepo;
    @Autowired
    RubroRepository rubroRepo;

    ProductoXRubroMapper pxrMapper;

    @Override
    public List<Producto> retrieveProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto retrieveByID(Long ID) {
        return productoRepo.findById(ID).orElse(null);
    }

    @Override
    public Producto retrieveByBarCode(String barcode) {
        return productoRepo.findByCodigoDeBarras(barcode).orElse(null);
    }

    @Override
    public List<Producto> retrieveByRubro(Long ID) {
        return pxrMapper.findByRubro(ID);
    }

    @Override
    public void agregarProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        productoRepo.save(producto);
    }
}
