package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.model.CodigoProdProv;
import com.montoy.facturacion.model.Producto;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.Rubro;
import com.montoy.facturacion.mybatismappers.ProductoXRubroMapper;
import com.montoy.facturacion.repositories.CodigoProdProvRepository;
import com.montoy.facturacion.repositories.ProductoRepository;
import com.montoy.facturacion.repositories.ProveedorRepository;
import com.montoy.facturacion.repositories.RubroRepository;
import com.montoy.facturacion.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepo;
    @Autowired
    RubroRepository rubroRepo;

    CodigoProdProvRepository codigoProvRepo;

    ProveedorRepository proveedorRepo;

    @Autowired
    ProductoXRubroMapper pxrMapper;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository,
                               CodigoProdProvRepository codigoProdProvRepository,
                               ProveedorRepository proveedorRepository,
                               ProductoXRubroMapper productoXRubroMapper){
        this.productoRepo = productoRepository;
        this.codigoProvRepo = codigoProdProvRepository;
        this.proveedorRepo = proveedorRepository;
        this.pxrMapper = productoXRubroMapper;
    }

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
    public Page<Producto> retrieve100perPage(Integer page) {
        return productoRepo.findAll(PageRequest.of(page-1,100));
    }

    @Override
    public Page<Producto> retrieve50perPage(Integer page) {
        return productoRepo.findAll(PageRequest.of(page-1,50));
    }

    @Override
    public Page<Producto> retrieve25perPage(Integer page) {
        return productoRepo.findAll(PageRequest.of(page-1,25));
    }

    @Override
    public List<Producto> retrieveByRubro(Long ID) {
        return pxrMapper.findByRubro(ID);
    }

    @Override
    public CodigoProdProv retrieveByProdAndProv(Long prod, Long prov) {
        Producto queryprod = this.retrieveByID(prod);
        Proveedor queryprov = proveedorRepo.findById(prov).orElse(null);
        CodigoProdProv codigo = codigoProvRepo.findByProductoAndProveedor(queryprod,queryprov).orElse(null);
        return codigo;
    }

    /*
    * Hola, aca en este servicio de productos agrego los codigos de productos por proveedor
    * Le puse el transactional pensando que si el agregado de los codigos seguidos de la factura
    * de entrada de stock se guardan en la misma transaccion no iba a fallar*/
    @Override
    @Transactional(transactionManager = "transactionManager")
    public void agregarCodigosProveedor(List<CodigoProdProv> codigos) {
        try {
            codigoProvRepo.saveAll(codigos);
        } finally {
            codigoProvRepo.flush();
        }
    }

    @Override
    public void agregarProducto(Producto producto) {
        LocalDateTime ingreso = LocalDateTime.now();
        producto.setFecha_creacion(ingreso);
        if (producto.getPlanillaStock()!=null) {
            producto.getPlanillaStock().setFecha_ultima_entrada(ingreso);
            producto.getPlanillaStock().setFecha_ultimo_ajuste(ingreso);
        }
        productoRepo.save(producto);
    }

    @Override
    public void actualizarProducto(Long ID, Producto producto) {
        Producto older = this.retrieveByID(ID);
        LocalDateTime modificacion = LocalDateTime.now();
        if (!Objects.equals(older.getPrecio(), producto.getPrecio()))
            producto.setFecha_modificacion_precio(modificacion);
        if (!producto.sonProductosIguales(older))
            producto.setFecha_modificacion(modificacion);
        if(Objects.isNull(older.getPlanillaStock()) &&
                !Objects.isNull(producto.getPlanillaStock()))
        {
            producto.getPlanillaStock().setFecha_ultima_entrada(modificacion);
            producto.getPlanillaStock().setFecha_ultimo_ajuste(modificacion);
        }
        productoRepo.save(producto);
    }
}
