package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.Cliente;
import com.montoy.facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
    List<Factura> findByCliente(@Param("cliente")Cliente cliente);
}
