package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.PlanillaStock;
import com.montoy.facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanillaStockRepository extends JpaRepository<PlanillaStock,Long> {

    PlanillaStock findByProducto(@Param("producto")Producto producto);
}
