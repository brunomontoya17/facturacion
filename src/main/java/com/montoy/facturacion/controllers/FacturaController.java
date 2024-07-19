package com.montoy.facturacion.controllers;

import com.montoy.facturacion.model.Factura;
import com.montoy.facturacion.services.implementations.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@Controller
@RestController
@RequestMapping("/facturacion")
public class FacturaController
{
    @Autowired
    FacturaServiceImpl facturaService;

    @GetMapping("/all")
    public ResponseEntity returnFacturas()
    {
        try {
            return ResponseEntity.ok(facturaService.retrieveFacturas());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{ID}")
    public ResponseEntity returnFacturaByID(@PathVariable Long ID)
    {
        try {
            return ResponseEntity.ok(facturaService.retrieveByID(ID));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/generatebill")
    public ResponseEntity emitirFactura(@RequestBody Factura factura)
    {
        try {
            LocalDateTime fecha_factura = LocalDateTime.now();
            factura.setFecha(fecha_factura);
            facturaService.insertarFactura(factura);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
