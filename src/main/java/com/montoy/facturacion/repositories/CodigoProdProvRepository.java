package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.CodigoProdProv;
import com.montoy.facturacion.model.Producto;
import com.montoy.facturacion.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodigoProdProvRepository extends JpaRepository<CodigoProdProv,Long> {

    Optional<CodigoProdProv> findByProductoAndProveedor(@Param("producto")Producto producto,
                                                        @Param("proveedor")Proveedor proveedor);
}
