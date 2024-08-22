package com.montoy.facturacion.controllers;


import com.montoy.facturacion.model.CodigoProdProv;
import com.montoy.facturacion.model.Producto;
import com.montoy.facturacion.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:5173")
@Controller
@RestController
@RequestMapping("/productos")
public class ProductoController
{
    @Autowired
    ProductoService productoService;


    @GetMapping("/all")
    public ResponseEntity returnProductos()
    {
        try {
            return ResponseEntity.ok(productoService.retrieveProductos());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/per100page/{Page}")
    public ResponseEntity return100ProductosxPagina(@PathVariable Integer Page)
    {
        try {
            return ResponseEntity.ok(productoService.retrieve100perPage(Page));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
    @GetMapping("/per50page/{Page}")
    public ResponseEntity return50ProductosxPagina(@PathVariable Integer Page)
    {
        try {
            return ResponseEntity.ok(productoService.retrieve50perPage(Page));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/per25page/{Page}")
    public ResponseEntity return25ProductosxPagina(@PathVariable Integer Page)
    {
        try {
            return ResponseEntity.ok(productoService.retrieve25perPage(Page));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
    @GetMapping("/{ID}")
    public ResponseEntity returnProductoByID(@PathVariable Long ID)
    {
        try {
            return ResponseEntity.ok(productoService.retrieveByID(ID));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/bybarcode/{Bar}")
    public ResponseEntity returnProductoByBarcode(@PathVariable String Bar)
    {
        try {
            return ResponseEntity.ok(productoService.retrieveByBarCode(Bar));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/byrubro/{ID}")
    public ResponseEntity returnProductosByRubro(@PathVariable Long ID)
    {
        try {
            return ResponseEntity.ok(productoService.retrieveByRubro(ID));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/codProdProv/{Prov}/{Prod}")
    public ResponseEntity returnCodigoProdXProv(@PathVariable Long Prov,@PathVariable Long Prod)
    {
        try {
            return ResponseEntity.ok(productoService.retrieveByProdAndProv(Prod,Prov));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("codProdProv/multi-insert")
    public ResponseEntity insertsListsOfCodes(@RequestBody List<CodigoProdProv> codigos)
    {
        try {
            productoService.agregarCodigosProveedor(codigos);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }


    @PostMapping("/insert")
    public ResponseEntity agregarProducto(@RequestBody Producto producto)
    {
        try {
            productoService.agregarProducto(producto);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/update/{ID}")
    public ResponseEntity actualizarProducto(@PathVariable Long ID,@RequestBody Producto producto)
    {
        try {
            productoService.actualizarProducto(ID,producto);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }


}
