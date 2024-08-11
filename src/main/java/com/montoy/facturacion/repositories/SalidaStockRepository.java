package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.Proveedor;
import com.montoy.facturacion.model.SalidaStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalidaStockRepository extends JpaRepository<SalidaStock,Long> {
    List<SalidaStock> findByProveedor(@Param("proveedor") Proveedor proveedor);
}
