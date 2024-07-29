package com.montoy.facturacion.repositories;

import com.montoy.facturacion.model.Rubro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro,Long> {
    Page<Rubro> findAll(Pageable pageable);
}
