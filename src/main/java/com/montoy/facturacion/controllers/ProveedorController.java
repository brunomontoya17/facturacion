package com.montoy.facturacion.controllers;

import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.services.implementations.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173","http://localhost:4173"})
@Controller
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorServiceImpl proveedorService;

    @GetMapping("/all")
    public ResponseEntity returnProveedores()
    {
        try {
            return ResponseEntity.ok(proveedorService.retrieveProveedores());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{ID}")
    public ResponseEntity returnProveedorByID(@PathVariable Long ID)
    {
        try {
            return ResponseEntity.ok(proveedorService.retrieveByID(ID));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/insert")
    public ResponseEntity agregarProveedor(@RequestBody Proveedor proveedor)
    {
        try {
            proveedorService.agregarProveedor(proveedor);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/update/{ID}")
    public ResponseEntity modificarProveedor(@PathVariable Long ID,@RequestBody Proveedor proveedor)
    {
        try {
            proveedorService.actualizarProveedor(proveedor);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
