package com.montoy.facturacion.controllers;

import com.montoy.facturacion.model.Rubro;
import com.montoy.facturacion.services.implementations.RubroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173","http://localhost:4173"})
@Controller
@RestController
@RequestMapping("/rubros")
public class RubroController
{
    @Autowired
    RubroServiceImpl rubroService;

    @GetMapping("/all")
    public ResponseEntity returnRubros()
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rubroService.retrieveRubros());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    @GetMapping("/{ID}")
    public ResponseEntity returnRubroByID(@PathVariable Long ID)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rubroService.retrieveByID(ID));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    @GetMapping("/per50page/{PAGE}")
    public ResponseEntity return50rubrosPerPage (@PathVariable Integer PAGE){
        try {
            return ResponseEntity.ok(rubroService.retrieve50perPage(PAGE));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/per25page/{PAGE}")
    public ResponseEntity return25rubrosPerPage (@PathVariable Integer PAGE){
        try {
            return ResponseEntity.ok(rubroService.retrieve25perPage(PAGE));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/per10page/{PAGE}")
    public ResponseEntity return10rubrosPerPage (@PathVariable Integer PAGE){
        try {
            return ResponseEntity.ok(rubroService.retrieve10perPage(PAGE));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/insert")
    public ResponseEntity agregarRubro(@RequestBody Rubro rubro)
    {
        try {
            rubro.setterLevel();
            rubroService.addRubro(rubro);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/update/{ID}")
    public ResponseEntity modificarRubro(@PathVariable Long ID,@RequestBody Rubro rubro)
    {
        try {
            rubro.setterLevel();
            rubroService.updateRubro(rubro);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
