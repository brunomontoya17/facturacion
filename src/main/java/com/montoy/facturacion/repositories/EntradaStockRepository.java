package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.EntradaStock;
import com.montoy.facturacion.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaStockRepository extends JpaRepository<EntradaStock, Long> {
    List<EntradaStock> findByProveedor(@Param("proveedor")Proveedor proveedor);
}
