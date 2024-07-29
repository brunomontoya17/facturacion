package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {

    Page<Marca> findAll(Pageable pageable);
}
