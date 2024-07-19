package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.PlanillaStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanillaStockRepository extends JpaRepository<PlanillaStock,Long> {
}
