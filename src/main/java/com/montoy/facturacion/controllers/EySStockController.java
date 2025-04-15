package com.montoy.facturacion.controllers;

import com.montoy.facturacion.model.EntradaStock;
import com.montoy.facturacion.services.EntradaStockService;
import com.montoy.facturacion.services.SalidaStockService;
import com.montoy.facturacion.services.implementations.EntradaStockServiceImpl;
import com.montoy.facturacion.services.implementations.SalidaStockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5173","http://localhost:4173"})
@Controller
@RestController
@RequestMapping("/eysstock")
public class EySStockController
{
    @Autowired
    EntradaStockService entradaService;

    @Autowired
    SalidaStockService salidaService;

    @Autowired
    public EySStockController (SalidaStockService salidaStockService,
                               EntradaStockService entradaStockService)
    {
        this.entradaService = entradaStockService;
        this.salidaService = salidaStockService;
    }

    @GetMapping("/entrada/all")
    public ResponseEntity returnEntradas()
    {
        try {
            return ResponseEntity.ok(entradaService.retrieveEntradas());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/entrada/insert")
    public ResponseEntity generarEntrada(@RequestBody EntradaStock entradaStock){
        try {
            entradaService.insertarEntradaStock(entradaStock);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
