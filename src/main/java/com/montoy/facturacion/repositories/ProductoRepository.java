package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    Optional<Producto> findByCodigoDeBarras(@Param(value="codigoDeBarras") String codigoDeBarras);

    Page<Producto> findAll(Pageable pageable);
}
