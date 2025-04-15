package com.montoy.facturacion.controllers;

import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.services.implementations.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173","http://localhost:4173"})
@Controller
@RestController
@RequestMapping("/clientes")
public class ClienteController
{
    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/all")
    public ResponseEntity returnClientes() {
        try {
            return ResponseEntity.ok(clienteService.retrieveClientes());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{ID}")
    public ResponseEntity returnClienteByID(@PathVariable Long ID)
    {
        try {
            return ResponseEntity.ok(clienteService.retrieveByID(ID));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/insert")
    public ResponseEntity agregarCliente(@RequestBody Cliente cliente)
    {
        try {
            clienteService.agregarCliente(cliente);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/update/{ID}")
    public ResponseEntity modificarCliente(@PathVariable Long ID,@RequestBody Cliente cliente)
    {
        try {
            clienteService.actualizarCliente(cliente);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
