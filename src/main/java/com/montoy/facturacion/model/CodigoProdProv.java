package com.montoy.facturacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="codigos_prod_prov", uniqueConstraints = @UniqueConstraint(columnNames = {"producto_id","proveedor_id"}))
public class CodigoProdProv
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCodProdProv;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    @Column(name = "codigo",nullable = false)
    private String codigo_proveedor;
}
