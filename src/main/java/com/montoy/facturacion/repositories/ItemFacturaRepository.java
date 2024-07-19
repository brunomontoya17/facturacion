package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFacturaRepository extends JpaRepository<ItemFactura,Long> {
}
