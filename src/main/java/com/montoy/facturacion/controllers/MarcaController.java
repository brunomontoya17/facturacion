package com.montoy.facturacion.controllers;

import com.montoy.facturacion.model.Marca;
import com.montoy.facturacion.model.Rubro;
import com.montoy.facturacion.services.implementations.MarcaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@Controller
@RestController
@RequestMapping("/marcas")
public class MarcaController
{
    @Autowired
    MarcaServiceImpl marcaService;

    @GetMapping("/all")
    public ResponseEntity returnMarcas(){
        try {
            return ResponseEntity.ok(marcaService.retrieveMarcas());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }


    @GetMapping("/{ID}")
    public ResponseEntity returnMarcaByID(@PathVariable Long ID)
    {
        try {
            return ResponseEntity.ok(marcaService.retrieveByID(ID));
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    @GetMapping("/per50page/{PAGE}")
    public ResponseEntity return50marcasPerPage(@PathVariable Integer PAGE){
        try {
            return ResponseEntity.ok(marcaService.retrieve50perPage(PAGE));
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/per25page/{PAGE}")
    public ResponseEntity return25marcasPerPage(@PathVariable Integer PAGE){
        try {
            return ResponseEntity.ok(marcaService.retrieve25perPage(PAGE));
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/per10page/{PAGE}")
    public ResponseEntity return10marcasPerPage(@PathVariable Integer PAGE){
        try {
            return ResponseEntity.ok(marcaService.retrieve10perPage(PAGE));
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/insert")
    public ResponseEntity agregarMarca(@RequestBody Marca marca)
    {
        try {
            marcaService.addMarca(marca);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    @PostMapping("/update/{ID}")
    public ResponseEntity modificarMarca(@PathVariable Long ID,@RequestBody Marca marca)
    {
        try {
            marcaService.updateMarca(marca);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
